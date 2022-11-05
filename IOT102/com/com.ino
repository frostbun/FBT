void setup() {
    Serial.begin(9600);
}

void loop() {
    if (Serial.available()) {
        String command = Serial.readStringUntil('/');
        if (command == "Phim1") {
            Serial.println("Mode1/");
        }
        if (command == "Phim2") {
            Serial.println("Mode2/");
        }
        if (command == "Phim3") {
            Serial.println("Mode3/");
        }
        if (command == "Phim4") {
            Serial.println("Mode4/");
        }
    }
}
