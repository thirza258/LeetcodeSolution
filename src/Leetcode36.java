public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        int count = 9;
        boolean[][] row = new boolean[count][count];
        boolean[][] column = new boolean[count][count];
        boolean[][] area = new boolean[count][count];
 
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(Character.isDigit(board[i][j]) == false) {
                    continue;
                }

                int idx = board[i][j] - '1';

                if(row[i][idx] == true) {
                    return false;
                }

                row[i][idx] = true;

                if(column[j][idx] == true) {
                    return false;
                }

                column[j][idx] = true;

                int areaIdx = (i / 3) * 3 + (j / 3);
                if(area[areaIdx][idx] == true) {
                    return false;
                }

                area[areaIdx][idx] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Leetcode36 lc = new Leetcode36();
        char[][] testCase = new char[9][9];
        testCase[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        testCase[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        testCase[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        testCase[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        testCase[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        testCase[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        testCase[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        testCase[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        testCase[8] = new char[]{'.','.','.','.','8','.','.','7','9'};
        System.out.println(lc.isValidSudoku(testCase));
    }
}
