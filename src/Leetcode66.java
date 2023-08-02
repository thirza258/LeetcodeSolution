

public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length - 1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        } else {
            int i = digits.length - 1;
            while(i >= 0 && digits[i] == 9) {
                digits[i] = 0;
                i--;
            }
            if(i == -1) {
                digits = new int[digits.length + 1]; // lebih baik buat array baru
                digits[0] = 1;
                return digits;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
    }
}
