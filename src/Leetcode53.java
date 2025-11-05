import java.util.List;

public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int currentSum = nums[n - 1];
        int maxSum = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
