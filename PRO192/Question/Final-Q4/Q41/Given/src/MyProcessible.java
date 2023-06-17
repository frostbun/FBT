public class MyProcessible implements Processible {

    public String intersect(String s1, String s2) {
        String ret = "";
        s2 = s2.toLowerCase();
        for(String s: s1.toLowerCase().split(" ")) {
            if(s2.contains(s) && !ret.contains(s)) {
                ret += s + ' ';
            }
        }
        return ret.trim();
    }
    
    public String getEmail(String fullname) {
        String[] s=fullname.split(" ");
        String ret = s[s.length-1];
        for(int i=0; i<s.length-1; ++i) {
            ret += s[i].charAt(0);
        }
        return ret + "@fpt.edu.vn";
    }
    
}
