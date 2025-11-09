import java.util.Deque;

public class Leetcode918 {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] prefixSums = new int[2 * n + 1];
        int totalSum = 0;
        Deque<Integer> deque = new java.util.ArrayDeque<>();
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < 2*n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i % n];
        }

        for(int i = 0; i < prefixSums.length; i++) {
            while(!deque.isEmpty() && i - deque.peekFirst() > n) {
                deque.pollFirst();
            }

            if(!deque.isEmpty()) {
                maxSum = Math.max(maxSum, prefixSums[i] - prefixSums[deque.peekFirst()]);
            }

            while(!deque.isEmpty() && prefixSums[i] <= prefixSums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return maxSum;

    }
}
