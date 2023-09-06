import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // Inisialisasi array list berisi integer untuk menyimpan hasil
        ArrayList<ArrayList<Integer>> nums1Subsets = new ArrayList<>();

        // mengisi nilai array list nums1Subsets
        for(int i=0; i < nums1.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums2[i]);
            temp.add(nums1[i]);
            nums1Subsets.add(temp);
        }

        // method compare untuk membandingkan nilai array list nums1Subsets
        Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                if(a.get(0).equals(b.get(0))) {
                    return Integer.compare(a.get(1), b.get(1));
                }
                return Integer.compare(a.get(0), b.get(0));
            }
        };

        // Melakukan sorting pada array list nums1Subsets
        Collections.sort(nums1Subsets, comparator);
        
        // inisialisasi nilai ans dan sum
        long ans = 0;
        long sum = 0;

        // inisialisasi priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Melakukan perulangan untuk menghitung nilai ans
        int n = nums1.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i >= n - k + 1) {
                sum += nums1Subsets.get(i).get(1);
                pq.offer(nums1Subsets.get(i).get(1));
            } else {
                sum += nums1Subsets.get(i).get(1);
                pq.offer(nums1Subsets.get(i).get(1));
                if (pq.size() > k) {
                    sum -= pq.poll();
                }
                ans = Math.max(ans, sum * 1L * nums1Subsets.get(i).get(0));
            }
        }

        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {
        Leetcode2542 leetcode2542 = new Leetcode2542();
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        System.out.println(leetcode2542.maxScore(nums1, nums2, k));
    }

}
