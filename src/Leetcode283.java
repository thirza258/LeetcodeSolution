public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        if(nums.length == 1) {
            return;
        }

        int fast = 0, slow = 0;
        while(fast < nums.length) {
            if (nums[fast] != 0) {
                if (fast != slow) {
                    nums[slow++] = nums[fast];
                }
            }
            fast++;
        }

        for(int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
