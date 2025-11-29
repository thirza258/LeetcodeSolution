public class Leetcode5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int[][] booleanTable = new int[s.length()][s.length()];

        String bestPalindrome = "";
        int bestLength = 0;

        for(int i = 0; i < s.length(); i++) {
            booleanTable[i][i] = 1;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                booleanTable[i][i+1] = 1;

                if (bestLength < 2) {
                    bestLength = 2;
                    bestPalindrome = s.substring(i, i+2);
                }
            } else {
                booleanTable[i][i + 1] = 0;
            }
        }

        for(int l = 3; l <= s.length(); l++) {
           for(int i = 0; i <= s.length() - l; i++) {
               int j = i + l -1;

               if(s.charAt(i) == s.charAt(j) && booleanTable[i + 1][j - 1] == 1) {
                   booleanTable[i][j] = 1;

               } else {
                   booleanTable[i][j] = 0;
               }

               if(booleanTable[i][j] == 1 && (j - i + 1) > bestLength) {
                   bestLength = j - i + 1;
                   bestPalindrome = s.substring(i, j + 1);
               }
           }
        }

        return bestLength == 0 ? s.substring(0, 1) : bestPalindrome;
    }
}
