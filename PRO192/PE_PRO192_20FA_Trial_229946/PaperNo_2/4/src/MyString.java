public class MyString implements IString {

    @Override
    public int f1(String str) {
        int count = 0;
        char[] primeList = {'2', '3', '5', '7'};
        for(char c: str.toCharArray()) {
            for(char prime: primeList) {
                if(c == prime) {
                    ++count;
                }
            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        String ret = "";
        for(String s: str.split(" ")) {
            ret = s + " " + ret;
        }
        return ret.trim();
    }
}
