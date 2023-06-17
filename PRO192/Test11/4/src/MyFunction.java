
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFunction implements DoSomething {

    @Override
    public int f1(String string) {
        int count = string.length();
        Matcher matcher = Pattern.compile("[a-zA-Z0-9\\s.,]").matcher(string);
        while(matcher.find()) {
            --count;
        }
        return count;
    }

    @Override
    public void f2(String string) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: string.toLowerCase().split(" ")) {
            int count = 0;
            if(map.containsKey(s)) {
                count = map.get(s);
            }
            map.put(s, count+1);
        }
        for(String s: map.keySet()) {
            System.out.format("%s: %d\n", s, map.get(s));
        }
    }
}
