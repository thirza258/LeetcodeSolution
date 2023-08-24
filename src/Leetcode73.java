public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRowZero = true;
                    }
                    if (j == 0) {
                        firstColumnZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int x = 1; x < matrix.length; x++) {
            for(int y = 1; y < matrix[x].length; y++) {
                if(matrix[x][0] == 0 || matrix[0][y] == 0) {
                    matrix[x][y] = 0;
                }
            }
        }

        if(firstRowZero) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(firstColumnZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode73 l = new Leetcode73();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        l.setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(java.util.Arrays.toString(matrix[i]));
        }
    }
}
