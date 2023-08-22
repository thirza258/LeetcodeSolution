import java.util.ArrayList;
import java.util.List;

public class Leetcode6 {
    public String convert(String s, int numRows) {
        if(numRows <= 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] listRows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
                listRows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = -1;

        for(int i = 0; i < s.length(); i++) {
            if(row == numRows - 1 || row == 0) {
                direction *= -1;
            }

            listRows[row].append(s.charAt(i));

            if(direction == 1) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < numRows; i++) {
            result.append(listRows[i]);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        Leetcode6 lc = new Leetcode6();
        System.out.println(lc.convert("PAYPALISHIRING", 3));
    }
}
