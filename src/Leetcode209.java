public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        boolean hasChecked = false;

        for(int i = 0; i < nums.length; i++, right++) {
            sum = sum + nums[i];

            while(sum >= target && left <= right) {
                if(left == right) {
                    return 1;
                }

                if(right - left + 1 <= minLen) {
                    minLen = right - left + 1;
                    hasChecked = true;
                }

                sum = sum - nums[left++];
            }
        }

        if(hasChecked) {
            return minLen;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Leetcode209 lc = new Leetcode209();
        int[] nums = {1,2,3,4,5};
        int target = 15;
        System.out.println(lc.minSubArrayLen(target, nums));
    }
}
