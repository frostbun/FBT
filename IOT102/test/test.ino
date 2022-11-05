#define LedR 11
#define LedY 12
#define LedG 13

#define Btn1 2
#define Btn2 3

void setup() {
    pinMode(LedR, OUTPUT);
    pinMode(LedY, OUTPUT);
    pinMode(LedG, OUTPUT);

    pinMode(Btn1, INPUT_PULLUP);
    pinMode(Btn2, INPUT_PULLUP);
}

void loop() {
    int x = digitalRead(Btn1);
    digitalWrite(LedR, !x);
    digitalWrite(LedG, !x);
    digitalWrite(LedY, !x);
}
