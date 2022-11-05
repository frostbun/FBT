#include <LiquidCrystal.h>

// keypad 4x4
#define hang1 13
#define hang2 12
#define cot1 11
#define cot2 10
#define cot3 9
#define cot4 8

// dong co (rem cua)
// Serial

// cam bien anh sanh
#define pinAnhSang A0

// cam bien nhiet do
#define pinNhietDo A1

// bao dong
#define pinBaoDong A3

// binh nong lanh (led xanh)
#define pinNongLanh A4

// dieu hoa (led do)
#define pinDieuHoa A5

// gia lap mo cua
#define pinMoCua A2

// lcd
LiquidCrystal lcd(7, 6, 5, 4, 3, 2);

unsigned long thoiGianBatDau = 6*3600L + 59*60 + 55;
int hour = 0;
int minute = 0;
int second = 0;

double nhietDo = 0;
int anhSang = 0;

int caiDatDieuHoa = 28;
int caiDatRemCua = 500;
int caiDatNongLanh = 17;

int cheDo = 0;
int trangThai = 1;

void setup() {
    Serial.begin(9600);

    lcd.begin(16, 2);

    pinMode(pinMoCua, INPUT_PULLUP);

    pinMode(pinNongLanh, OUTPUT);
    pinMode(pinDieuHoa, OUTPUT);
    pinMode(pinBaoDong, OUTPUT);

    pinMode(hang1, OUTPUT);
    pinMode(hang2, OUTPUT);
    pinMode(cot1, INPUT_PULLUP);
    pinMode(cot2, INPUT_PULLUP);
    pinMode(cot3, INPUT_PULLUP);
    pinMode(cot4, INPUT_PULLUP);
}

char scanMatrix() {
    // bật hàng 1 và tắt tất cả các hàng còn lại rồi xét cột
    digitalWrite(hang1, LOW);
    digitalWrite(hang2, HIGH);
    if (digitalRead(cot1) == 0) return '1';
    if (digitalRead(cot2) == 0) return '2';
    if (digitalRead(cot3) == 0) return '3';
    if (digitalRead(cot4) == 0) return 'A';

    // bật hàng 2 và tắt tất cả các hàng còn lại rồi xét cột
    digitalWrite(hang1, HIGH);
    digitalWrite(hang2, LOW);
    if (digitalRead(cot1) == 0) return '4';
    if (digitalRead(cot2) == 0) return '5';
    if (digitalRead(cot3) == 0) return '6';
    if (digitalRead(cot4) == 0) return 'B';

    return '?';
}

char prevCode = '?';

char scanMatrixOneTouch() {
    char code = scanMatrix();
    if (code != prevCode) {
        prevCode = code;
        return code;
    }
    return '?';
}

unsigned long prevMillis = 0;
int tang(int in, int step) {
    unsigned long curMillis = millis();
    if (curMillis - prevMillis >= 300) {
        prevMillis = curMillis;
        in += step;
    }
    return in;
}

void capNhatThoiGian() {
    unsigned long time = millis() / 1000 + thoiGianBatDau;
    hour = int(time / 3600 % 24);
    minute = int(time / 60 % 60);
    second = int(time % 60);
}

String formatThoiGian() {
    String res = "";
    res += char(hour/10 % 10 + '0');
    res += char(hour % 10 + '0');
    res += ":";
    res += char(minute/10 % 10 + '0');
    res += char(minute % 10 + '0');
    res += ":";
    res += char(second/10 % 10 + '0');
    res += char(second % 10 + '0');
    return res;
}

void capNhatAnhSangNhietDo() {
    anhSang = analogRead(pinAnhSang);
    double dienAp = analogRead(pinNhietDo) * 5.0 / 1024.0;
    nhietDo = dienAp * 100.0;
}

void hienThiManHinhChinh() {
    lcd.setCursor(0, 0);
    lcd.print("Tmp: ");
    lcd.print(nhietDo);
    lcd.setCursor(0, 1);
    lcd.print("LDR: ");
    lcd.print(anhSang);
    lcd.print("  ");
}

void log() {
    Serial.print("Time: ");
    Serial.print(formatThoiGian());

    Serial.print(" Tmp: ");
    Serial.print(nhietDo);

    Serial.print(" LDR: ");
    Serial.println(anhSang);
}

void hienThiMenu(int trangThai) {
    if (trangThai == 1) {
        lcd.setCursor(0, 0);
        lcd.print("1.Thoi gian thuc");
        lcd.setCursor(0, 1);
        lcd.print("2.Cai dieu hoa");
    }
    if (trangThai == 2) {
        lcd.setCursor(0, 0);
        lcd.print("3.Cai rem cua");
        lcd.setCursor(0, 1);
        lcd.print("4.Cai nong lanh");
    }
}

void hienThiThoiGian() { // menu 1
    lcd.setCursor(0, 0);
    lcd.print("Time: ");
    lcd.print(formatThoiGian());
}

void hienThiCaiDatDieuHoa() { // menu 2
    lcd.setCursor(0, 0);
    lcd.print("Cai dat nhiet do:");
    lcd.setCursor(7, 1);
    lcd.print(caiDatDieuHoa);
}

void hienThiCaiDatRemCua() { // menu 3
    lcd.setCursor(0, 0);
    lcd.print("Cai dat rem cua");
    lcd.setCursor(7, 1);
    lcd.print(caiDatRemCua);
}

void hienThiCaiDatNongLanh() { // menu 4
    lcd.setCursor(0, 0);
    lcd.print("Cai dat NL(hour)");
    lcd.setCursor(7, 1);
    lcd.print(caiDatNongLanh);
}

void exitBtn(String mess, char c) {
    if (c == '5' || c == 'B') {
        cheDo = 5;
        lcd.clear();
        Serial.println(mess);
        trangThai = 1;
    }
}

void selectBtn(char c) {
    if (c == '1') {
        Serial.println("Ban vua vao thoi gian thuc");
        lcd.clear();
        cheDo = 1;
        trangThai = 1;
    }
    if (c == '2') {
        Serial.println("Ban vua vao cai dat dieu hoa");
        lcd.clear();
        cheDo = 2;
        trangThai = 1;
        Serial.print("Dieu hoa se bat o ");
        Serial.print(caiDatDieuHoa);
        Serial.print(" va tat o ");
        Serial.println(caiDatDieuHoa-5);
    }
    if (c == '3') {
        Serial.println("Ban vua vao cai dat rem cua");
        lcd.clear();
        cheDo = 3;
        trangThai = 1;
        Serial.print("Rem cua se mo luc ");
        Serial.println(caiDatRemCua);
    }
    if (c == '4') {
        Serial.println("Ban vua vao cai dat nong lanh");
        lcd.clear();
        cheDo = 4;
        trangThai = 1;
        Serial.print("Binh nong lanh se mo luc ");
        Serial.print(caiDatNongLanh);
        Serial.println("h va tat sau 10p");
    }
    if (c == '5' || c == 'B') {
        cheDo = 0;
        lcd.clear();
        Serial.println("Ban vua thoat khoi menu");
    }
}

void kiemTraDieuHoa() {
    int alpha = 1;
    if (nhietDo >= caiDatDieuHoa && digitalRead(pinDieuHoa) == LOW) {
        digitalWrite(pinDieuHoa, HIGH);
        Serial.println("Dieu hoa da bat");
    }
    if (nhietDo <= caiDatDieuHoa - 5 && digitalRead(pinDieuHoa) == HIGH) {
        digitalWrite(pinDieuHoa, LOW);
        Serial.println("Dieu hoa da tat");
    }
}

int trangThaiRemCua = 0;
void kiemTraRemCua() {
    int alpha = 50;
    if (anhSang >= caiDatRemCua + alpha && trangThaiRemCua == 0) {
        trangThaiRemCua = 1;
        Serial.println("Rem da mo/");
    }
    if (anhSang <= caiDatRemCua - alpha && trangThaiRemCua == 1) {
        trangThaiRemCua = 0;
        Serial.println("Rem da dong/");
    }
}

void kiemTraNongLanh() {
    if (caiDatNongLanh == hour && minute>=0 && minute<=9) {
        if (digitalRead(pinNongLanh) == LOW) {
            digitalWrite(pinNongLanh, HIGH);
            Serial.println("Binh nong lanh da bat");
        }
    }
    else {
        if (digitalRead(pinNongLanh) == HIGH) {
            digitalWrite(pinNongLanh, LOW);
            Serial.println("Binh nong lanh da tat");
        }
    }
}

int thoiGianBaoDong = 0;
void kiemTraCua() {
    if ((hour >= 22 || hour < 6) && digitalRead(pinMoCua) == 0) {
        Serial.println("Cua da mo");
        digitalWrite(pinBaoDong, HIGH);
        thoiGianBaoDong = 1000; // (10s)
    }
    else if (thoiGianBaoDong > 0) {
        --thoiGianBaoDong;
        if (thoiGianBaoDong == 0) {
            digitalWrite(pinBaoDong, LOW);
        }
    }
}

unsigned long time1, time2, time3;

void loop() {
    capNhatThoiGian();

    if (millis() - time1 > 1000) { // moi giay cap nhat 1 lan
        capNhatAnhSangNhietDo();
        kiemTraDieuHoa();
        kiemTraRemCua();
        kiemTraNongLanh();
        // Ban serial
        log();
        time1 = millis();
    }

    if (millis() - time2 > 10) { // moi giay kiem tra 100 lan
        kiemTraCua();
        time2 = millis();
    }

    switch (cheDo) {
        case (0): // man hinh chinh
        {
            hienThiManHinhChinh();
            if (scanMatrixOneTouch() == '5') {
                cheDo = 5;
                Serial.println("Ban da vao menu");
                trangThai = 1;
                lcd.clear();
            }
            break;
        }
        case (1): // thoi gian thuc
        {
            char c = scanMatrixOneTouch();
            hienThiThoiGian();
            exitBtn("Ban vua thoat khoi thoi gian thuc", c);
            break;
        }
        case (2): // dieu hoa
        {
            char c = scanMatrixOneTouch();
            hienThiCaiDatDieuHoa();
            if (scanMatrix() == '6') {
                caiDatDieuHoa = tang(caiDatDieuHoa, 1) % 40;
            }
            exitBtn("Ban vua thoat khoi cai dat dieu hoa", c);
            break;
        }
        case (3):  // rem cua
        {
            char c = scanMatrixOneTouch();
            hienThiCaiDatRemCua();
            if (scanMatrix() == '6') {
                caiDatRemCua = tang(caiDatRemCua, 10) % 1000;
            }
            exitBtn("Ban vua thoat khoi cai dat rem cua", c);
            break;
        }
        case (4):  // nong lanh
        {
            char c = scanMatrixOneTouch();
            hienThiCaiDatNongLanh();
            if (scanMatrix() == '6') {
                caiDatNongLanh = tang(caiDatNongLanh, 1) % 24;
            }
            exitBtn("Ban vua thoat khoi cai dat nong lanh", c);
            break;
        }
        case (5):  // menu
        {
            hienThiMenu(trangThai);
            char c = scanMatrixOneTouch();
            if (c == 'A') {
                if (trangThai == 2) {
                    trangThai = 1;
                } else {
                    trangThai = 2;
                }
                lcd.clear();
            }
            selectBtn(c);
            break;
        }
    }
}
