public class Leetcode1004 {
    public int longestOnes(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        int left = 0;
        int maxLength = 0;
        int zeros = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeros += 1;
            }

            while(zeros > k) {
                if(nums[left] == 0) {
                    zeros -= 1;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
