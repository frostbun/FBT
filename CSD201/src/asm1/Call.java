package asm1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Call {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final List<String> VALID_TYPES = Arrays.asList("NH", "LC", "X", "RX");

    private final String phone;
    private final int duration;
    private final int time;
    private final LocalDate date;
    private final String type;

    public Call(String phone, int duration, int time, LocalDate date, String type) {
        this.phone = phone;
        this.duration = duration;
        this.time = time;
        this.date = date;
        this.type = type;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getType() {
        return this.type;
    }

    public double getFee() {
        double fee = 400 * this.duration * (VALID_TYPES.indexOf(this.type)+1);
        if (
            this.time >= 23*60 ||
            this.time <= 5*60 ||
            this.date.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
            this.date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
        ) fee *= 0.7;
        return fee;
    }

    public String toString() {
        return String.format(
            "%s %d %d.%d %s %s",
            this.phone,
            this.duration,
            this.time/60,
            this.time%60,
            this.date.format(DATETIME_FORMATTER),
            this.type
        );
    }

    public static List<Call> load(String file) {
        List<Call> callList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] args = line.trim().split(" ");
                    String phone = args[0];
                    int duraion =  Integer.parseInt(args[1]);
                    String[] time = args[2].split("\\.");
                    int hour = Integer.parseInt(time[0]);
                    int minute = Integer.parseInt(time[1]);
                    LocalDate date = LocalDate.parse(args[3], DATETIME_FORMATTER);
                    String type = args[4];
                    if (!phone.matches("^8\\d{6}$")) continue;
                    if (duraion < 1 || duraion > 120) continue;
                    if (hour < 0 || hour > 23 || minute < 0 || minute > 59) continue;
                    if (!VALID_TYPES.contains(type)) continue;
                    callList.add(new Call(phone, duraion, hour*60+minute, date, type));
                }
                catch (RuntimeException e) {}
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return callList;
    }
}
