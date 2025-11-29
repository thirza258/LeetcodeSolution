public class Leetcode221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxSide = 0;

        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    if(matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        maxSide = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                else {
                    int top = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int topLeft = dp[i - 1][j - 1];

                    if(matrix[i - 1][j - 1] == '1') {
                        int minNeighbor;
                        if(top <= left && top <= topLeft) {
                            minNeighbor = top;
                        } else if(left <= top && left <= topLeft) {
                            minNeighbor = left;
                        } else {
                            minNeighbor = topLeft;
                        }

                        dp[i][j] = 1 + minNeighbor;
                        if(dp[i][j] > maxSide) {
                            maxSide = dp[i][j];
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        return maxSide * maxSide;
    }
}
