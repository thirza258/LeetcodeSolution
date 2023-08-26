import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        
        if(intervals.length <= 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int i = 0; i < intervals.length; i++) {
            int result_size = result.size();

            if(result_size > 0 && result.get(result_size - 1)[1] >= intervals[i][0]) {
                result.get(result_size - 1)[1] = Math.max(result.get(result_size - 1)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        
        int[][] result_array = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            result_array[i] = result.get(i);
        }

        return result_array;
    }

    public static void main(String[] args) {
        Leetcode56 l = new Leetcode56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = l.merge(intervals);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
