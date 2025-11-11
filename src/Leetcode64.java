import java.util.HashMap;

public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        if(rows == 1 && cols == 1) {
            return grid[0][0];
        }

        int[][] memo = new int[rows][cols];

       for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(i == 0 && j == 0) {
                    memo[i][j] = grid[i][j];
                } else if(i == 0) {
                    memo[0][j] = memo[0][j - 1] + grid[0][j];
                } else if(j == 0) {
                    memo[i][0] = memo[i - 1][0] + grid[i][0];
                } else {
                    memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
                }
            }
        }

        return memo[rows - 1][cols - 1];
    }
}
