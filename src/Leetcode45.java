public class Leetcode45 {
    /*
     * 45. Jump Game II
     */
    public int jump(int[] nums) {
        // jika panjang nums kurang dari sama dengan 1, return 0
        if (nums.length <= 1) {
            return 0;
        }

        // inisiasi langkah dan coverIndex
        // langkah untuk menghitung jumlah langkah yang diperlukan untuk mencapai akhir array
        int step = 0;
        // coverIndex untuk menentukan indeks maksimum yang dapat dicapai
        int coverIndex = 0;

        // iterasi untuk setiap elemen di nums dan selama coverIndex kurang dari panjang nums
        for(int i = 0; i <= coverIndex && i < nums.length; ) {
            // jika nilai elemen di indexs i adalah 0, return nilai terkecil dari integer
            if (nums[i] == 0) {
                return Integer.MIN_VALUE;
            }

            // jika nilai coverIndex lebih kecil dari nilai elemen di index i + i
            if(coverIndex < nums[i] + i) {
                // maka nilai coverIndex adalah nilai elemen di index i + i
                coverIndex = nums[i] + i;
                // nilai step ditambah 1
                step++;
            }

            // jika nilai coverIndex lebih besar atau sama dengan panjang nums - 1, return step atau indeks terakhir
            if(coverIndex >= nums.length - 1) {
                return step;
            }

            // inisiasi nilai nextIndex dan maxDistance
            // nextIndex untuk menentukan indeks selanjutnya
            int nextIndex = 0;
            // maxDistance untuk menentukan jarak maksimum yang dapat dicapai
            int maxDistance = 0;
            // iterasi untuk setiap elemen di nums dari indeks i + 1 sampai coverIndex
            for(int j = i+1; j <= coverIndex; j++) {
                // jika nilai elemen di index j + j lebih besar dari maxDistance
                if(nums[j] + j > maxDistance) {
                    // maka nilai maxDistance adalah nilai elemen di index j + j
                    maxDistance = nums[j] + j;
                    nextIndex = j;
                }
            }

            // nilai i adalah nilai nextIndex
            i = nextIndex;
        }

        return step;
    }

    public static void main(String[] args) {
        Leetcode45 lc = new Leetcode45();
        int[] nums = {2,3,1,1,4};
        System.out.println(lc.jump(nums));
    }
}
