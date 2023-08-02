

public class Leetcode20 {
    public boolean isValid(String s) {
        boolean valid = true;
        if(s.length()%2 == 1) {
            return false;
        }
        for(int i = 0; i < s.length() - 1; i+=2) {
            if(s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                continue;
            } else if(s.charAt(i) == '{' && s.charAt(i + 1) == '}') {
                continue;
            } else if(s.charAt(i) == '[' && s.charAt(i + 1) == ']') {
                continue;
            } else {
                return false;
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        Leetcode20 lc = new Leetcode20();
        String s = "()[]{}";
        System.out.println(lc.isValid(s));
    }
}
