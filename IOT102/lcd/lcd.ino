#include <LiquidCrystal.h>

#define ledR 11
#define ledY 12
#define ledG 13

#define btn1 2
#define btn2 3

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

    bool operator==(Time other) {
        return hour == other.hour && minute == other.minute && second == other.second;
    }
};

enum Mode {
    MODE_NORMAL,
    MODE_SET_HOUR,
    MODE_SET_MINUTE,
    MODE_SET_SECOND,
    MODE_ROll_NUMBER,
    MODE_COUNT
};

LiquidCrystal lcd = LiquidCrystal(9, 8, 7, 6, 5, 4);

Time now = Time(0);
Time alm = Time(0);

unsigned long time_offset = 12*3600L + 0*60 + 0;
unsigned long alarm = 21*3600L + 0*60 + 0;

int mode = MODE_NORMAL;

int btn1_last_state = 1;
int btn2_last_state = 1;

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

    btn1_last_state = btn1_state;
    btn2_last_state = btn2_state;
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
