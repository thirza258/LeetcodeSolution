import java.util.HashMap;

public class Leetcode594 {
    /*
     * 594. Longest Harmonious Subsequence
     */
    public int findLHS(int[] nums) {
        // jika panjang dari array nums adalah 1, maka return 0
        if(nums.length == 1) {
            return 0;
        }

        // inisialisasi hashmap dengan isi key dan value berupa integer
        HashMap<Integer, Integer> map = new HashMap<>();

        // insialisasi nilai result
        int result = 0;
        // mengiterasi nilai array nums
        for(int i = 0; i < nums.length; i++) {
            // Jika map tidak mengandung key nums[i]
            if(!map.containsKey(nums[i])) {
                // maka masukkan nilai nums[i] sebagai key dan value 1
                map.put(nums[i], 1);
            }else {
                // jika map mengandung key nums[i], maka tambahkan value dari key nums[i] dengan 1
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }   

        // mengiterasi nilai hashmap
        for(Integer key : map.keySet()) {
            // jika map mengandung key + 1
            if(map.containsKey(key+1)) {
                // maka tambahkan nilai result dengan nilai dari key key dan key+1
                result = Math.max(result, map.get(key) + map.get(key+1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode594 leetcode594 = new Leetcode594();
        int[] nums = {-3,-1,-1,-1,-3,-2};
        System.out.println(leetcode594.findLHS(nums));
    }
}
