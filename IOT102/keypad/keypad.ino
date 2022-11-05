#define R1 13
#define R2 12
#define R3 11
#define R4 10

#define C1 9
#define C2 8
#define C3 7
#define C4 6

void setup() {
    pinMode(R1, OUTPUT);
    pinMode(R2, OUTPUT);
    pinMode(R3, OUTPUT);
    pinMode(R4, OUTPUT);

    pinMode(C1, INPUT_PULLUP);
    pinMode(C2, INPUT_PULLUP);
    pinMode(C3, INPUT_PULLUP);
    pinMode(C4, INPUT_PULLUP);

    Serial.begin(9600);
}

void loop() {
    int code = 255;

    digitalWrite(R1, 0);
    digitalWrite(R2, 1);
    digitalWrite(R3, 1);
    digitalWrite(R4, 1);
    if (digitalRead(C1) == 0) code = 1;
    if (digitalRead(C2) == 0) code = 2;
    if (digitalRead(C3) == 0) code = 3;
    if (digitalRead(C4) == 0) code = 'A';

    digitalWrite(R1, 1);
    digitalWrite(R2, 0);
    digitalWrite(R3, 1);
    digitalWrite(R4, 1);
    if (digitalRead(C1) == 0) code = 4;
    if (digitalRead(C2) == 0) code = 5;
    if (digitalRead(C3) == 0) code = 6;
    if (digitalRead(C4) == 0) code = 'B';

    digitalWrite(R1, 1);
    digitalWrite(R2, 1);
    digitalWrite(R3, 0);
    digitalWrite(R4, 1);
    if (digitalRead(C1) == 0) code = 7;
    if (digitalRead(C2) == 0) code = 8;
    if (digitalRead(C3) == 0) code = 9;
    if (digitalRead(C4) == 0) code = 'C';

    digitalWrite(R1, 1);
    digitalWrite(R2, 1);
    digitalWrite(R3, 1);
    digitalWrite(R4, 0);
    if (digitalRead(C1) == 0) code = '*';
    if (digitalRead(C2) == 0) code = 0;
    if (digitalRead(C3) == 0) code = '#';
    if (digitalRead(C4) == 0) code = 'D';

    Serial.println(code);
    delay(100);
}
