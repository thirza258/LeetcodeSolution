public class Leetcode162 {
    public int findPeakElement(int[] nums) {

        if(nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }

            if(left == right) {
                return left;
            }
        }
        return left;
    }
}
