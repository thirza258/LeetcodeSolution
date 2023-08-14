public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        final int MAXCHAR = 256;
        int[] maps = new int[MAXCHAR];
        int[] mapt = new int[MAXCHAR];

        for(int i = 0; i < s.length(); i++) {
            maps[s.charAt(i)]++;
        }

        for(int j = 0; j < t.length(); j++) {
            mapt[t.charAt(j)]++;
        }

        for(int i = 0; i < MAXCHAR; i++) {
            if(maps[i] != mapt[i]) {
                return false;
            }
        }
        return true;
    }
}
