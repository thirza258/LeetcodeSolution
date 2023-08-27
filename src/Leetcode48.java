

import java.util.Arrays;

public class Leetcode48 {
    /*
     * 48. Rotate Image
     */
    public void rotate(int[][] matrix) {
        // inisiasi nilai row
        int row = 0;

        // iterasi untuk  
        for(int i = 0; i < matrix.length/2; i++) {
            row = matrix.length - 1 - i;
            for(int j = i; j < row; j++) {
                int offset = j - i;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-offset][i];
                matrix[row-offset][i] = matrix[row][row-offset];
                matrix[row][row-offset] = matrix[j][row];
                matrix[j][row] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode48 lc = new Leetcode48();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        lc.rotate(matrix);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        
    }
}
