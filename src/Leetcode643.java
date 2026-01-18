public class Leetcode643 {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 0) {
            return 0.0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        double maxAverage = Double.NEGATIVE_INFINITY;

        for(int i = 0; i  <= nums.length - k; i++) {
            int sum = 0;
            for(int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            double average = (double) sum / k;
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }
}
