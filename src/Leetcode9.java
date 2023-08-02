

public class Leetcode9 {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        } else if (x == 1) {
            return true;
        } else if (x < 0) {
            return false;
        }
        else {
            int temp = x;
            int reverse = 0;
            while(x > 0) { 
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }
            return temp == reverse;
        }
    }

    public static void main(String[] args) {
        Leetcode9 n = new Leetcode9();
        System.out.println(n.isPalindrome(1234567899));
    }
}
