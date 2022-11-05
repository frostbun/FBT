#include <LiquidCrystal.h>

#define ledR 11
#define ledY 12
#define ledG 13

#define btn1 2
#define btn2 3

#define vr A0
#define ls A1
#define ts A2

struct Time {
    unsigned long hour;
    unsigned long minute;
    unsigned long second;
    char str[9];

    Time(unsigned long time) {
        hour = time / 3600 % 24;
        minute = time / 60 % 60;
        second = time % 60;
        sprintf(str, "%02lu:%02lu:%02lu", hour, minute, second);
    }

    Time(unsigned long h, unsigned long m, unsigned long s) {
        hour = h;
        minute = m;
        second = s;
        sprintf(str, "%02lu:%02lu:%02lu", hour, minute, second);
    }

    bool operator==(Time other) {
        return hour == other.hour && minute == other.minute && second == other.second;
    }

    // static int diff(Time t1, Time t2) {
    //     return (t2.hour-t1.hour) * 3600 + (t2.minute-t1.minute) * 60 + (t2.second-t1.second);
    // }
};

enum Mode {
    MODE_NORMAL,
    MODE_SET_HOUR,
    MODE_SET_MINUTE,
    MODE_SET_SECOND,
    MODE_ROll_NUMBER,
    MODE_ANALOG_INPUT,
    MODE_TEMPERATURE_SENSOR,
    MODE_COUNT
};

LiquidCrystal lcd = LiquidCrystal(9, 8, 7, 6, 5, 4);

Time now = Time(0);
Time alm = Time(0);

const int alpha = 50;

unsigned long time_offset = 12*3600L + 0*60 + 0;
unsigned long alarm = 21*3600L + 0*60 + 0;

int mode = MODE_TEMPERATURE_SENSOR;

int btn1_last_state = 1;
int btn2_last_state = 1;
int vr_last_state;
int ls_last_state;
int ts_last_state;

void input() {
    int btn1_state = digitalRead(btn1);
    int btn2_state = digitalRead(btn2);

    if (btn1_last_state == 1 && btn1_state == 0) {
        mode = (mode + 1) % MODE_COUNT;
    }

    if (btn2_last_state == 1 && btn2_state == 0) {
        switch (mode) {
            case MODE_SET_HOUR:
                alarm += 3600;
                break;
            case MODE_SET_MINUTE:
                alarm += 60;
                break;
            case MODE_SET_SECOND:
                alarm += 1;
                break;
        }
    }

    if (Serial.available()) {
        String command = Serial.readStringUntil('/');
        if (command.startsWith("Mode=")) {
            mode = command.substring(5, command.length()).toInt() % MODE_COUNT;
        }
        if (command.startsWith("Time=")) {
            unsigned long h = (unsigned long)command.substring(5, 7).toInt();
            unsigned long m = (unsigned long)command.substring(8, 10).toInt();
            unsigned long s = (unsigned long)command.substring(11, 13).toInt();
            // time_offset += Time::diff(Time(millis()/1000+time_offset), Time(h, m, s));
        }
        if (command.startsWith("Alarm=")) {
            unsigned long h = (unsigned long)command.substring(6, 8).toInt();
            unsigned long m = (unsigned long)command.substring(9, 11).toInt();
            unsigned long s = (unsigned long)command.substring(12, 14).toInt();
            alarm = h*3600 + m*60 + s;
        }
    }

    btn1_last_state = btn1_state;
    btn2_last_state = btn2_state;
    vr_last_state = analogRead(vr);
    ls_last_state = analogRead(ls);
    ts_last_state = analogRead(ts);
}

void output() {
    switch (mode) {
        case MODE_NORMAL:
            lcd.setCursor(0, 0);
            lcd.print("Time:  ");
            lcd.print(now.str);
            lcd.setCursor(0, 1);
            lcd.print("Alarm: ");
            lcd.print(alm.str);
            break;
        case MODE_SET_HOUR:
            lcd.setCursor(0, 0);
            lcd.print("Alarm: ");
            lcd.print(alm.str);
            lcd.setCursor(0, 1);
            lcd.print("       ^^       ");
            break;
        case MODE_SET_MINUTE:
            lcd.setCursor(0, 0);
            lcd.print("Alarm: ");
            lcd.print(alm.str);
            lcd.setCursor(0, 1);
            lcd.print("          ^^    ");
            break;
        case MODE_SET_SECOND:
            lcd.setCursor(0, 0);
            lcd.print("Alarm: ");
            lcd.print(alm.str);
            lcd.setCursor(0, 1);
            lcd.print("             ^^ ");
            break;
        case MODE_ROll_NUMBER:
            lcd.setCursor(0, 0);
            lcd.print("Nguyen Duc Manh");
            lcd.setCursor(0, 1);
            lcd.print("    HE163620    ");
            break;
        case MODE_ANALOG_INPUT:
            lcd.setCursor(0, 0);
            lcd.print("ADC0: ");
            lcd.print(vr_last_state);
            lcd.print("      ");
            lcd.setCursor(0, 1);
            lcd.print("ADC1: ");
            lcd.print(ls_last_state);
            lcd.print("      ");
            // Serial.print(vr_last_state);
            // Serial.print(" ");
            // Serial.println(ls_last_state);
            if (ls_last_state < vr_last_state-alpha) {
                digitalWrite(ledR, 1);
            }
            if (ls_last_state > vr_last_state+alpha) {
                digitalWrite(ledR, 0);
            }
            break;
        case MODE_TEMPERATURE_SENSOR:
            double temperature = ts_last_state * 5.0 / 1023 * 100;
            lcd.setCursor(0, 0);
            lcd.print(temperature);
            lcd.print("            ");
            lcd.setCursor(0, 1);
            lcd.print("                ");
            delay(1000);
            break;
    }
}

void blink() {
    for (int i=0; i<10; ++i) {
        // turn on led
        digitalWrite(ledR, 1);
        digitalWrite(ledY, 1);
        digitalWrite(ledG, 1);
        // turn on display
        lcd.setCursor(0, 0);
        lcd.print("Time:  ");
        lcd.print(now.str);
        lcd.setCursor(0, 1);
        lcd.print("Alarm: ");
        lcd.print(alm.str);
        delay(500);
        // turn off led
        digitalWrite(ledR, 0);
        digitalWrite(ledY, 0);
        digitalWrite(ledG, 0);
        // clear display
        lcd.clear();
        delay(500);
    }
}

void setup() {
    pinMode(ledR, OUTPUT);
    pinMode(ledY, OUTPUT);
    pinMode(ledG, OUTPUT);

    pinMode(btn1, INPUT_PULLUP);
    pinMode(btn2, INPUT_PULLUP);

    lcd.begin(16, 2);

    Serial.begin(9600);
}

void loop() {
    input();
    now = Time(millis() / 1000 + time_offset);
    alm = Time(alarm);
    output();
    if (alm == now) {
        blink();
    }
}
