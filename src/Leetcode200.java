public class Leetcode200 {
    public int numIslands(char[][] grid) {
        int countIsland = 0;

        if (grid.length == 0 || grid == null) {
            return 0;
        } 

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    countIsland++;
                    dfs(grid, r, c);
                }
            }
        }

        return countIsland;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        
        dfs(grid, r - 1, c);  
        dfs(grid, r + 1, c); 
        dfs(grid, r, c - 1); 
        dfs(grid, r, c + 1);  
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        Leetcode200 leetcode200 = new Leetcode200();
        System.out.println(leetcode200.numIslands(grid));
    }
}
