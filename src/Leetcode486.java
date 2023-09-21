import java.util.HashMap;

public class Leetcode486 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public boolean predictTheWinner(int[] nums) {
        // inisialisasi panjang dari array
        int n = nums.length;
        int total_size = 0;
        // menghitung total size dari array
        for(int i = 0; i < n; i++) {
            total_size += nums[i];
        }
        // memanggil fungsi helper dengan memasukkan array, index awal, dan index akhir
        int player1 = helper(nums, 0, n - 1);
        // player2 adalah total_size - player1 karena player1 selalu mengambil nilai terbesar
        int player2 = total_size - player1;
        return player1 >= player2;
    }

    public int helper(int nums[], int i, int j) {
        // Jika index awal lebih besar dari index akhir maka akan mengembalikan 0
        if(i > j) {
            return 0;
        }

        if(map.containsKey(i+j)) {
            return map.get(i+j);
        }
        // Jika index awal sama dengan index akhir maka akan mengembalikan nilai dari index awal
        if(i == j) {
            return nums[i];
        }

        // Mengambil angka terkecil dari kedua sisi yaitu ketika player 1 mengabil angka dari index pertama
        // dan mengambil angka dari index terakhir 
        int start = nums[i] + Math.min(helper(nums, i+2, j), helper(nums, i+1, j-1));
        int end = nums[j] + Math.min(helper(nums, i+1, j-1), helper(nums, i, j-2));

        if(!map.containsKey(i+j)) {
            map.put(i+j, Math.max(start, end));
        }

        return Math.max(start, end);
    }

    public static void main(String[] args) {
        Leetcode486 lc = new Leetcode486();
        int[] nums = {1, 5, 2};
        System.out.println(lc.predictTheWinner(nums));
    }
}
