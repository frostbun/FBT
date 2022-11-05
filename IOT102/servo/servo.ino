/* Sweep
 by BARRAGAN <http://barraganstudio.com>
 This example code is in the public domain.

 modified 8 Nov 2013
 by Scott Fitzgerald
 https://www.arduino.cc/en/Tutorial/LibraryExamples/Sweep
*/

#include <Servo.h>

Servo myservo;  // create servo object to control a servo
// twelve servo objects can be created on most boards

int pos = 0;  // variable to store the servo position

void setup() {
    myservo.attach(9);  // attaches the servo on pin 9 to the servo object
    Serial.begin(9600);
}

unsigned long last = millis();

void loop() {
    int a = analogRead(A0);
    Serial.println(a);
    if (a > 640) {
        myservo.write(30);
        last = millis();
    }
    if (millis() > last + 50) {
        myservo.write(0);
    }
}
