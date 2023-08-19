public class Leetcode45 {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int step = 0;
        int coverIndex = 0;

        for(int i = 0; i <= coverIndex && i < nums.length; ) {
            if ( nums[i] == 0) {
                return Integer.MIN_VALUE;
            }

            if(coverIndex < nums[i] + i) {
                coverIndex = nums[i] + i;
                step++;
            }

            if(coverIndex >= nums.length - 1) {
                return step;
            }

            int nextIndex = 0;
            int maxDistance = 0;
            for(int j = i+1; j <= coverIndex; j++) {
                if(nums[j] + j > maxDistance) {
                    maxDistance = nums[j] + j;
                    nextIndex = j;
                }
            }

            i = nextIndex;
        }

        return step;
    }

    public static void main(String[] args) {
        Leetcode45 lc = new Leetcode45();
        int[] nums = {2,3,1,1,4};
        System.out.println(lc.jump(nums));
    }
}
