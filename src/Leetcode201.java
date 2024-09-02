public class Leetcode201 {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }

    public static void main(String[] args) {
        Leetcode201 leetcode201 = new Leetcode201();
        System.out.println(leetcode201.rangeBitwiseAnd(5, 7));
        System.out.println(leetcode201.rangeBitwiseAnd(0, 0));
        System.out.println(leetcode201.rangeBitwiseAnd(1, 2147483647));
        System.out.println(leetcode201.rangeBitwiseAnd(0, 2147483647));
    }
}
