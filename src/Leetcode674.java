public class Leetcode674 {
    /*
     * 674. Longest Continuous Increasing Subsequence
     */
    public int findLengthOfLCIS(int[] nums) {
        // inisiasi base case
        if(nums.length == 1) {
            return 1;
        }
        if(nums.length == 0) {
            return 0;
        }

        // inisiasi nilai result dan temp
        // result untuk menyimpan subsequence terpanjang
        // temp untuk menyimpan jumlah subsequence yang terus bertambah
        int result = 1;
        int temp = 1;

        // iterasi nilai array nums
        for(int i = 1; i < nums.length; i++) {
            // Jika nilai nums[i] lebih besar dari nilai nums[i-1]
            // atau nilai sekarang lebih besar dari nilai sebelumnya
            if(nums[i] > nums[i - 1]) {
                // maka tambahkan nilai temp dengan 1
                temp += 1;
            }
            else {
                // Mengeset nilai result dengan nilai maksimum dari result dan temp
                result = Math.max(result, temp);
                // mereset nilai temp menjadi 1
                temp = 1;
            }
        }
        // Mengembalikan nilai maksimum dari result dan temp
        return Math.max(result, temp);
    }

    public static void main(String[] args) {
        Leetcode674 leetcode674 = new Leetcode674();
        int[] nums = {1,3,5,4,7};
        System.out.println(leetcode674.findLengthOfLCIS(nums));
    }
}
