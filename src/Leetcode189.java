public class Leetcode189 {
    public void rotateRecursion(int[] nums, int k) {
        if(k <= 0) {
            return;
        }
        k = k % nums.length;
        helper(nums, nums.length - k, nums.length - 1);
        helper(nums, 0, nums.length - k - 1);
        helper(nums, 0, nums.length - 1);
    }

    public void helper(int nums[], int start, int end) {
        int temp = 0;
        while(start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    
    public static void main(String[] args) {
        Leetcode189 lc = new Leetcode189();
        int[] nums = {1,2,3,4,5,6,7};
        lc.rotateRecursion(nums, 3);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
