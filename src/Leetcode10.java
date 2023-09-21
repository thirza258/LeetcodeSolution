public class Leetcode10 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        

        if (p.length() <= 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        }

        int len = s.length();
        int i = -1;
        while(i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
            if(isMatch(s.substring(i + 1), p.substring(2))) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode10 lc = new Leetcode10();
        String s = "aa";
        String p = "a*";
        System.out.println(lc.isMatch(s, p));
    }
}
