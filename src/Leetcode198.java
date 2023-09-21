import java.util.ArrayList;
import java.util.Collections;

public class Leetcode198 {
    

    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int [] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        return helper(nums, 0, dp);
    }

    public int helper(int[] nums, int i, int[] dp) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1 ) {
            return dp[i];
        }

        int rob = nums[i] + helper(nums, i+2, dp);

        int notRob = helper(nums, i+1, dp);

        dp[i] = Math.max(rob, notRob);
        return dp[i];
    }

    public static void main(String[] args) {
        Leetcode198 lc = new Leetcode198();
        int[] nums = {1, 2, 3, 1};
        System.out.println(lc.rob(nums));
    }
}
