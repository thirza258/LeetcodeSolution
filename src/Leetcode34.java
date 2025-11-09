public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }

        if(nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }

        int leftIndex = findLeftIndex(nums, target);
        if(leftIndex == -1) {
            return new int[]{-1, -1};
        }
        int rightIndex = findRightIndex(nums, target);
        return new int[]{leftIndex, rightIndex};
    }

    private int findLeftIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftIndex = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                leftIndex = mid;
                right = mid -1;
            } else if(nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid -1;
            }
        }
      return leftIndex;
    }

    private int findRightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightIndex = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                rightIndex = mid;
                left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rightIndex;
    }

}
