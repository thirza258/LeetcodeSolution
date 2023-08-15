public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) {
            return 0;
        }
        
        int firstIndex = 0;
        int lastIndex = nums.length;
        int midIndex = 0;

        if(target > nums[lastIndex - 1]) {
            return lastIndex;
        }

        while(firstIndex <= lastIndex) {
            midIndex = (firstIndex + lastIndex) / 2;
            if(nums[midIndex] == target) {
                return midIndex;
            }

            if(target < nums[midIndex]) {
                lastIndex = midIndex - 1;
            } else {
                firstIndex = midIndex + 1;
            }
        }
        return firstIndex;
    }

    public static void main(String[] args) {
        Leetcode35 leetcode35 = new Leetcode35();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(leetcode35.searchInsert(nums, target));
    }
    
}
