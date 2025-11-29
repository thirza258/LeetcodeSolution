public class Leetcode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;

        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 && j > 0) {
                    if(dp[i][j - 1] == 1 && s2.charAt(j-1) == s3.charAt(j - 1)) {
                        dp[i][j] = 1;
                    }
                }

                if(j == 0 && i > 0) {
                    if (dp[i - 1][j] == 1 && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                        dp[i][j] = 1;
                    }
                }

                if(j > 0 && i > 0) {
                    int k = i + j - 1;

                    if(dp[i - 1][j] == 1 && s1.charAt(i - 1) == s3.charAt(k)) {
                        dp[i][j] = 1;
                    }

                    if(dp[i][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(k)) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        if(dp[s1.length()][s2.length()] == 1) {
            return true;
        }
        return false;
    }
}
