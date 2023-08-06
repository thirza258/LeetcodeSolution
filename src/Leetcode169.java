public class Leetcode169 {
    public int majorityElement(int[] nums) {
        // mengeset nilai majority dengan nilai terkecil dari integer
        int majority = Integer.MIN_VALUE;
        // mengeset nilai count dengan 0
        int count = 0;
        // mengiterasi array nums
        for(int i = 0; i < nums.length; i++) {
            // jika count bernilai 0 atau iterasi pertama
            if (count == 0) {
                // mengassign nilai majority dengan nilai dari array nums
                majority = nums[i];
                // menambahkan nilai count dengan 1
                count++;
            }
            else {
                // jika nilai dari array nums sama dengan nilai dari majority dan hitungan ditambahkan dengan 1
                if (nums[i] == majority) {
                    count++;
                }

                else {
                    // jika tidak maka hitungan dikurangi dengan 1
                    count--;
                }
                // jika hitungan lebih dari setengah panjang array nums maka langsung mengembalikan nilai majority
                // karena nilainya pasti mayoritas
                if(count > nums.length/2) {
                    return majority;
                }
            }
        }
        return majority;
    }
}
