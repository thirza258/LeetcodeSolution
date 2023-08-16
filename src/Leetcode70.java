public class Leetcode70 {
    public int climbStairs(int n) {
        if(n <= 3) {
            return n;
        }

        int[] a = new int[]{2,3};
        for(int i = 4; i <= n; i++) {
            int temp = a[0] + a[1];
            a[0] = a[1];
            a[1] = temp;
        }
        return a[1];
    }
}
