import java.util.List;
import java.util.ArrayList;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        if(rowSize <= 0 || colSize <= 0) {
            return result;
        }


        for(int rowStart = 0, columnStart = 0; rowStart < ((rowSize + 1)/2) && columnStart < ((colSize+1)/2); rowStart++, columnStart++) {
            //atas
            for(int i = columnStart; i < colSize-columnStart; i++) {
                result.add(matrix[rowStart][i]);
            }
            
            //kanan
            for(int i = rowStart + 1; i < rowSize - rowStart; i++) {
                result.add(matrix[i][colSize - columnStart - 1]);
            }

            //bawah
            for(int i = colSize - columnStart - 2; rowSize - rowStart - 1 > rowStart && i > columnStart; i--) {
                result.add(matrix[rowSize - rowStart - 1][i]);
            }

            //kiri
            for(int i = rowSize - rowStart - 1; colSize - columnStart - 1 > columnStart && i > rowStart; i--) {
                result.add(matrix[i][columnStart]);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Leetcode54 l = new Leetcode54();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = l.spiralOrder(matrix);
        System.out.println(result);
    }
}
