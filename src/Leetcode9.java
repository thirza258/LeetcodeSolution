

public class Leetcode9 {
    public boolean isPalindrome(int x) {
        // Jika x sama dengan 0 atau 1 maka mengembalikan true
        if (x == 0) {
            return true;
        } else if (x == 1) {
            return true;
        } else if (x < 0) {
            return false;
        }
        else {
            // membuat variabel temp untuk menyimpan x 
            int temp = x;
            int reverse = 0;
            // jika x lebih dari 0 maka akan di reverse
            while(x > 0) { 
                // rumus untuk versi reverse dari angka adalah reverse = reverse * 10 + x % 10
                reverse = reverse * 10 + x % 10;
                // dan nilai x akan dibagi 10
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
