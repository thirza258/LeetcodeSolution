public class Leetcode172 {
    public int trailingZeroes(int n) {

        int count = 0;
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }

        return count;
    }

    public static void main(String[] args) {
        Leetcode172 obj = new Leetcode172();
        System.out.println(obj.trailingZeroes(3));
        System.out.println(obj.trailingZeroes(5));
        System.out.println(obj.trailingZeroes(0));
    }
}
