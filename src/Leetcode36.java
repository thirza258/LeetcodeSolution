public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {

        // inisiasi count sebagai ukuran dari board
        int count = 9;
        // inisiasi 3 array 2 dimensi dengan ukuran count x count
        // row untuk array 2 dimensi yang merepresentasikan baris
        boolean[][] row = new boolean[count][count];
        // column untuk array 2 dimensi yang merepresentasikan kolom
        boolean[][] column = new boolean[count][count];
        // area untuk array 2 dimensi yang merepresentasikan area 3x3
        boolean[][] area = new boolean[count][count];
        
        // iterasi untuk setiap elemen di board
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                // jika elemen di board bukan angka, lanjutkan
                if(Character.isDigit(board[i][j]) == false) {
                    continue;
                }

                // inisiasi idx sebagai nilai dari elemen di board dikurangi 1
                int idx = board[i][j] - '1';

                // jika elemen di board sudah pernah muncul di baris, return false
                if(row[i][idx] == true) {
                    return false;
                }

                // mengeset nilai row[i][idx] menjadi true
                row[i][idx] = true;

                // jika elemen di board sudah pernah muncul di kolom, return false
                if(column[j][idx] == true) {
                    return false;
                }

                // mengeset nilai column[j][idx] menjadi true
                column[j][idx] = true;

                // areaIdx untuk menentukan area 3x3 mana yang akan diisi
                int areaIdx = (i / 3) * 3 + (j / 3);
                // jika elemen di board sudah pernah muncul di area 3x3, return false
                if(area[areaIdx][idx] == true) {
                    return false;
                }

                // mengeset nilai area[areaIdx][idx] menjadi true
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
