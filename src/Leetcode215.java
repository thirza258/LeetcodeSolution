public class Leetcode215 {
    // 215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestQsort(nums, k);
    }

    int partition(int [] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;

        while(l <= r) {
            if(nums[l] < pivot && nums[r] > pivot) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            if(nums[l] >= pivot) {
                l++;
            }
            if(nums[r] <= pivot) {
                r--;
            }
        }

        int temp = nums[left];
        nums[left] = nums[r];
        nums[r] = temp;
        return r;
    }

    int findKthLargestQsort(int [] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while(true) {
            int pos = partition(nums, left, right);
            if(pos == k - 1) {
                return nums[pos];
            } 
            if(pos > k - 1) {
                right = pos - 1;
            } 
            else {
                left = pos + 1;
            }
        }
    }



}
