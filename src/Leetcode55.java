public class Leetcode55 {
    public boolean canJump(int[] nums) {
        if(nums.length <= 0) {
            return false;
        }

        int coverIndex = 0;

        for(int i = 0; i <= coverIndex && i < nums.length; i++) {
            if(coverIndex < nums[i] + i) {
                coverIndex = nums[i] + i;
            }

            if(coverIndex >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Leetcode55 lc = new Leetcode55();
        int[] nums = {2,3,1,1,4};
        int [] nums2 = {3,2,1,0,4};
        System.out.println(lc.canJump(nums));
        System.out.println(lc.canJump(nums2));
    }
}
