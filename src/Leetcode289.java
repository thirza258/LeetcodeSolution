public class Leetcode289 {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                helper(board, i, j);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] >>=  1;
            }
        }
    }

    public void helper(int[][] board, int x, int y) {
        int count = 0;
        for(int i = x - 1; i <= x + 1; i++) {
            if(i < 0 || i >= board.length) {
                continue;
            }
            for(int j = y - 1; j <= y + 1; j++) {
                if(j < 0 || j >= board[0].length || i == x && j == y) {
                    continue;
                }
                if((board[i][j] & 1) == 1) {
                    count++;
                }
            }
        }   

        if(board[x][y] == 1 && (count == 2 || count == 3)) {
            board[x][y] = 3;
        } 
        
        if(board[x][y] == 0 && count == 3) {
            board[x][y] = 2;
        }
    }

    public static void main(String[] args) {
        Leetcode289 l = new Leetcode289();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        l.gameOfLife(board);
        for(int i = 0; i < board.length; i++) {
            System.out.println(java.util.Arrays.toString(board[i]));
        }
    }
}
