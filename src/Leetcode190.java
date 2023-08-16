public class Leetcode190 {
    public int reverseBits(int n) {
        int ret = n;
        for(int i = 0; i < 32; i++) {
            // melakukan shift bit ke kiri sebanyak 1 bit atau di kali 2 dan menambahkan LSB dari n
            ret = (ret << 1) + (n & 0x1);
            // Menlakukan shift bit ke kanan sebanyak 1 bit atau di bagi 2
            n >>= 1;
        }
        return ret;
    }
}
