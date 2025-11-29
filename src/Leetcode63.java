public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] memo = new int[rows][cols];

        memo[0][0] = 1;

        for (int i = 1; i < rows; i++) {
            memo[i][0] = (obstacleGrid[i][0] == 0 && memo[i - 1][0] == 1) ? 1 : 0;
        }

        for (int j = 1; j < cols; j++) {
            memo[0][j] = (obstacleGrid[0][j] == 0 && memo[0][j - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 0)
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                else
                    memo[i][j] = 0;
            }
        }


        return memo[rows - 1][cols - 1];
    }
}
