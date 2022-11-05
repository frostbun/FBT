#include<LiquidCrystal.h>

#define ledR 11
#define ledY 12
#define ledG 13

#define btn1 2
#define btn2 3

LiquidCrystal lcd(9, 8, 7, 6, 5, 4);

int mode = 0;
int btn1_state = 1;
int btn2_state = 2;

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
    unsigned long time = millis();
    unsigned long second = time % 60;
    unsigned long minute = time / 60 % 60;

    lcd.setCursor(0, 0);
    lcd.print(second);
    delay(1000);
}
