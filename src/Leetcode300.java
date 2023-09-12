import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode300 {
    List<Integer> longestSubSequence = new ArrayList<>();

    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 1) {
            return 1;
        }
        if(nums.length == 0) {
            return 0;
        }

        int length = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            length = Math.max(length, dp[i]);
        }
        return length;
    }

    private int binarySearch(int number) {
        int start = 0;
        // inisiasi nilai end dengan panjang dari array list longestSubSequence - 1 yaitu nilai paling akhir dari array list longestSubSequence
        int end = longestSubSequence.size() - 1;
        // jika nilai start sama dengan nilai end
        if(start == end) {
            // jika nilai number lebih besar dari nilai longestSubSequence pada index start
            if(number > longestSubSequence.get(start)) {
                // maka return start+1
                return start+1;
            }
            else {
                // jika tidak, maka mengembalikan nilai start
                return start;
            }
        }

        // Selama nilai start kurang dari nilai end
        while(start < end) {
            // Jika nilai start sama dengan nilai end - 1
            if(start == end - 1) {
                // Jika nilai number lebih besar dari nilai longestSubSequence pada index start
                // dan nilai number kurang dari atau sama dengan nilai longestSubSequence pada index end
                if(number > longestSubSequence.get(start) && number <= longestSubSequence.get(end)) {
                    // kembalikan nilai end
                    return end;
                }
                // Jika nilai number kurang dari atau sama dengan nilai longestSubSequence pada index start
                else if(number <= longestSubSequence.get(start)) {
                    return start;
                }
                // Jika tidak, maka kembalikan nilai end+1
                else {
                    return end+1;
                }
            }
            // inisiasi nilai middle dengan nilai tengah dari start dan end
            int middle = (start + end + 1) / 2;
            // Jika nilai number sama dengan nilai longestSubSequence pada index middle
            if(longestSubSequence.get(middle) < number) {
                start = middle;
            }
            // Jika tidak, maka set nilai end dengan nilai middle
            else {
                end = middle;
            }
        }
        return Math.max(start, end);
    }

    public int lis(int[] nums) {
        // inisiasi nilai result
        int result = 0;

        // Jika panjang dari array nums lebih dari 0
        if(nums.length > 0) {
            // inisiasi nilai result dengan 1
            result = 1;
            // menambahkan nilai nums[0] ke dalam array list longestSubSequence
            longestSubSequence.add(nums[0]);
            // iterasi nilai array nums
            for(int i = 1; i < nums.length; i++) {
                // inisiasi nilai position dengan nilai dari method binarySearch dengan parameter nums[i]
                int position = binarySearch(nums[i]);
                // Jika nilai position sama dengan panjang dari array list longestSubSequence
                if(position == longestSubSequence.size()) {
                    // maka tambahkan nilai nums[i] ke dalam array list longestSubSequence
                    longestSubSequence.add(nums[i]);
                }
                else {
                    // jika tidak, maka set nilai nums[i] ke dalam array list longestSubSequence pada index position
                    longestSubSequence.set(position, nums[i]);
                }
                // set nilai result dengan nilai maksimum dari result dan position+1
                result = Math.max(result, position+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode300 leetcode300 = new Leetcode300();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(leetcode300.lis(nums));
    }
}
