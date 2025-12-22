import java.util.PriorityQueue;

public class Leetcode295 {
    private PriorityQueue<Integer> lowHeap; // Max-heap for the lower half
    private PriorityQueue<Integer> highHeap; // Min-heap for the upper half

    private int difference = 0;
    public Leetcode295() {
        lowHeap = new PriorityQueue<>((a, b) -> b - a);
        highHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(lowHeap.isEmpty() || num <= lowHeap.peek()) {
            lowHeap.offer(num);
            difference++;
        } else {
            highHeap.offer(num);
            difference--;
        }

        rebalanceHeaps();
    }

    private void rebalanceHeaps() {
        if(difference > 1) {
            highHeap.offer(lowHeap.poll());
            difference -= 2;
        } else if(difference < -1) {
            lowHeap.offer(highHeap.poll());
            difference += 2;
        }
    }

    public double findMedian() {
        int topFromLow = lowHeap.isEmpty() ? 0 : lowHeap.peek();
        int topFromHigh = highHeap.isEmpty() ? 0 : highHeap.peek();

        int totalSize = lowHeap.size() + highHeap.size();
        if(totalSize % 2 == 0) {
            return (topFromLow + topFromHigh) / 2.0;
        } else {
            return difference > 0 ? topFromLow : topFromHigh;
        }
    }
}
