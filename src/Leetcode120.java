import java.util.List;
import java.util.ArrayList;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }

        for(int i = 1; i < triangle.size(); i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    int minPath = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                    triangle.get(i).set(j, triangle.get(i).get(j) + minPath);
                }
            }
        }

        int minTotal = Integer.MAX_VALUE;
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for(int i = 0; i < lastRow.size(); i++) {
            minTotal = Math.min(minTotal, lastRow.get(i));
        }

        return minTotal;
    }
}
