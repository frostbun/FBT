public class MyString implements IString {

    @Override
    public int f1(String str) {
        int count = 0;
        for(String s: str.split(" ")) {
            if(s.toLowerCase().endsWith("m") || s.toLowerCase().endsWith("n")) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        String[] ret = str.split(" ");
        int index = -1;
        for(int i=0; i<ret.length; ++i) {
            if(index == -1 || ret[i].length() > ret[index].length()) {
                index = i;
            }
        }
        if(index >= 0) {
            String tmp = "";
            for(char c: ret[index].toCharArray()) {
                tmp = c + tmp;
            }
            ret[index] = tmp;
        }
        return String.join(" ", ret);
    }
}
