package utils;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader implements Closeable {

    private static final String DEFAULT_ERROR_MESSAGE = "Invalid input";

    private final Scanner scanner;

    public Reader() {
        scanner = new Scanner(System.in);
    }

    //#region integer
    public int getInteger(String prompt, int min, int max, String error) {
        while(true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int ret = Integer.parseInt(input);
                if (ret < min || ret > max) {
                    System.err.println(error);
                    continue;
                }
                return ret;
            }
            catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }

    public int getInteger(String prompt, String error) {
        return getInteger(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE, error);
    }

    public int getInteger(String prompt, int min, int max) {
        return getInteger(prompt, min, max, DEFAULT_ERROR_MESSAGE);
    }

    public int getInteger(String prompt) {
        return getInteger(prompt, DEFAULT_ERROR_MESSAGE);
    }

    public int getInteger() {
        return getInteger("Input integer: ");
    }
    //#endregion

    //#region integer list
    public List<Integer> getIntegerList(String prompt, String error) {
        while(true) {
            System.out.print(prompt);
            String[] input = scanner.nextLine().trim().split(" ");
            try {
                List<Integer> integerList = new ArrayList<>();
                for (String string: input) {
                    integerList.add(Integer.parseInt(string));
                }
                return integerList;
            }
            catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }

    public List<Integer> getIntegerList(String prompt) {
        return getIntegerList(prompt, DEFAULT_ERROR_MESSAGE);
    }

    public List<Integer> getIntegerList() {
        return getIntegerList("Input integers list: ");
    }

    public List<Integer> getIntegerList(int count, String prompt, String error) {
        while(true) {
            List<Integer> integerList = getIntegerList(prompt, error);
            if (integerList.size() == count) {
                return integerList;
            }
            System.err.println(error);
        }
    }

    public List<Integer> getIntegerList(int count, String prompt) {
        return getIntegerList(count, prompt, DEFAULT_ERROR_MESSAGE);
    }

    public List<Integer> getIntegerList(int count) {
        return getIntegerList(count, "Input "+count+" integers: ");
    }
    //#endregion

    //#region double
    public double getDouble(String prompt, double min, double max, String error) {
        while(true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double ret = Double.parseDouble(input);
                if (ret < min || ret > max) {
                    System.err.println(error);
                    continue;
                }
                return ret;
            }
            catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }

    public double getDouble(String prompt, String error) {
        return getDouble(prompt, Double.MIN_VALUE, Double.MAX_VALUE, error);
    }

    public double getDouble(String prompt, double min, double max) {
        return getDouble(prompt, min, max, DEFAULT_ERROR_MESSAGE);
    }

    public double getDouble(String prompt) {
        return getDouble(prompt, DEFAULT_ERROR_MESSAGE);
    }

    public double getDouble() {
        return getDouble("Input double: ");
    }
    //#endregion

    //#region double list
    public List<Double> getDoubleList(String prompt, String error) {
        while(true) {
            System.out.print(prompt);
            String[] input = scanner.nextLine().trim().split(" ");
            try {
                List<Double> doubleList = new ArrayList<>();
                for (String string: input) {
                    doubleList.add(Double.parseDouble(string));
                }
                return doubleList;
            }
            catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }

    public List<Double> getDoubleList(String prompt) {
        return getDoubleList(prompt, DEFAULT_ERROR_MESSAGE);
    }

    public List<Double> getDoubleList() {
        return getDoubleList("Input doubles list: ");
    }

    public List<Double> getDoubleList(int count, String prompt, String error) {
        while(true) {
            List<Double> doubleList = getDoubleList(prompt, error);
            if (doubleList.size() == count) {
                return doubleList;
            }
            System.err.println(error);
        }
    }

    public List<Double> getDoubleList(int count, String prompt) {
        return getDoubleList(count, prompt, DEFAULT_ERROR_MESSAGE);
    }

    public List<Double> getDoubleList(int count) {
        return getDoubleList(count, "Input "+count+" doubles: ");
    }
    //#endregion

    //#region string
    public String getPattern(String prompt, String pattern, String error) {
        while(true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if(!input.matches(pattern)) {
                System.err.println(error);
                continue;
            }
            return input;
        }
    }

    public String getPattern(String prompt, String pattern) {
        return getPattern(prompt, pattern, DEFAULT_ERROR_MESSAGE);
    }

    public String getPattern(String pattern) {
        return getPattern("Input pattern: ", pattern);
    }

    public String getString(String prompt, String error) {
        return getPattern(prompt, "^.+$", error);
    }

    public String getString(String prompt) {
        return getString(prompt, DEFAULT_ERROR_MESSAGE);
    }

    public String getString() {
        return getString("Input string: ");
    }

    public String getRawString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public String getRawString() {
        return getRawString("Input string: ");
    }
    //#endregion

    //#region choice
    public int getChoice(String title, List<String> menu, String prompt, int min, int max, String error) {
        System.out.println(title);
        for(String line: menu) {
            System.out.println(line);
        }
        return getInteger(prompt, min, max, error);
    }

    public int getChoice(String title, List<String> menu, String prompt, String error) {
        return getChoice(title, menu, prompt, 1, menu.size(), error);
    }

    public int getChoice(String title, List<String> menu, String prompt, int min, int max) {
        return getChoice(title, menu, prompt, min, max, DEFAULT_ERROR_MESSAGE);
    }

    public int getChoice(String title, List<String> menu, String prompt) {
        return getChoice(title, menu, prompt, DEFAULT_ERROR_MESSAGE);
    }

    public int getChoice(String title, List<String> menu) {
        return getChoice(title, menu, "Your choice: ");
    }
    //#endregion

    //#region confirm
    public boolean confirm(String prompt, String yes, String no, String error) {
        String pattern = String.format(
            "^(%s)|(%s)|(%s)|(%s)$",
            yes.toLowerCase(),
            no.toLowerCase(),
            yes.toUpperCase(),
            no.toUpperCase()
        );
        return getPattern(prompt, pattern, error).equalsIgnoreCase(yes);
    }

    public boolean confirm(String prompt, String yes, String no) {
        return confirm(prompt, yes, no, DEFAULT_ERROR_MESSAGE);
    }

    public boolean confirm(String prompt) {
        return confirm(prompt, "y", "n");
    }

    public boolean confirm() {
        return confirm("Confirm (y/n): ", "y", "n");
    }
    //#endregion

    public void close() {
        scanner.close();
    }
}