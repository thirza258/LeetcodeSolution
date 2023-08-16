public class Leetcode191 {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 0x1) == 1) {
                cnt++;
            }
            n >>= 1;
        }
        return cnt;
    }
}
