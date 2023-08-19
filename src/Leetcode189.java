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
        if(start >= end) {
            return;
        }
        int temp = nums[start];
        nums[start++] = nums[end];
        nums[end--] = temp;
    }

    public void rotateLoop(int nums[], int k) {
        if (k <= 0 || nums.length <= 1) {
            return;
        }

        k = k % nums.length;

        int currentIndex = 0;
        int newIndex = k;
        int temp = nums[currentIndex];
        int temp2 = 0;
        int realIndex = 0;

        for(int i = 0; i < nums.length; i++) {
            temp2 = nums[newIndex];
            nums[newIndex] = temp;
            temp = temp2;

            currentIndex = newIndex;

            if (realIndex == currentIndex) {
                realIndex = ++currentIndex;
                temp = nums[currentIndex];
            }

            newIndex = (currentIndex + k) % nums.length;
        }
    }

    public static void main(String[] args) {
        Leetcode189 lc = new Leetcode189();
        int[] nums = {1,2,3,4,5,6,7};
        lc.rotateLoop(nums, 3);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
