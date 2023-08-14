public class Leetcode205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        final int MAXCHAR = 256;
        int[] maps = new int[MAXCHAR];
        int[] mapt = new int[MAXCHAR];

        for(int i = 0; i < s.length(); i++) {
            if(maps[s.charAt(i)] == 0 && mapt[t.charAt(i)] == 0) {
                maps[s.charAt(i)] = t.charAt(i);
                mapt[t.charAt(i)] = s.charAt(i);
                continue;
            }
            if(maps[s.charAt(i)] == t.charAt(i) && mapt[t.charAt(i)] == s.charAt(i)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode205 leetcode205 = new Leetcode205();
        System.out.println(leetcode205.isIsomorphic("egg", "add"));
    }
}
