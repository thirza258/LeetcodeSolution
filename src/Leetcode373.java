import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Leetcode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        PriorityQueue<SumEntry> minHeap = new PriorityQueue<>(Comparator.comparingInt(entry -> entry.sum));

        for(int i = 0; i < Math.min(n1, k); i++) {
            minHeap.offer(new SumEntry(nums1[i] + nums2[0], i, 0));
        }

        while(!minHeap.isEmpty() && result.size() < k) {
            SumEntry currentEntry = minHeap.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[currentEntry.i]);
            pair.add(nums2[currentEntry.j]);
            result.add(pair);

            if(currentEntry.j + 1 < n2) {
                minHeap.offer(new SumEntry(nums1[currentEntry.i] + nums2[currentEntry.j + 1], currentEntry.i, currentEntry.j + 1));
            }
        }
        return  result;

    }
}

class SumEntry {
    int sum;
    int i;
    int j;

    public SumEntry(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }

}
