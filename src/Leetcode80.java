public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int position = 0;
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[position]) {
                count++;

                if(count == 2) {
                    nums[++position] = nums[i];
                }
            }
            else {
                count = 1;
                nums[++position] = nums[i];
            }
        }

        return position + 1;
    }

    public static void main(String[] args) {
        Leetcode80 lc = new Leetcode80();
        int[] nums = {1,1,1,2,2,3};
        int len = lc.removeDuplicates(nums);
        for(int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
