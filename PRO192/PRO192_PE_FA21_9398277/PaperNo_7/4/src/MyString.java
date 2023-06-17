public class MyString implements IString {

    @Override
    public int f1(String str) {
        int count = 0;
        String[] evenDigit = "02468".split("");
        for(String s: str.split("\\s+")) {
            for(String c: evenDigit) {
                if(s.contains(c)) {
                    ++count;
                    break;
                }
            }
        }
        return count;
    }
    
    private boolean isPalindrom(String s) {
        int n = s.length();
        for(int i=0; i<n/2; ++i) {
            if(s.charAt(i) != s.charAt(n-1-i)) {
                return false;
            }
        }        
        return true;
    }

    @Override
    public String f2(String str) {
        String[] ret = str.split("\\s+");
        for(int i=0; i<ret.length; ++i) {
            if(isPalindrom(ret[i])) {
                ret[i] = "YY";
                break;
            }
        }
        return String.join(" ", ret);
    }
}
