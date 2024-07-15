import java.util.Arrays;

public class Leetcode452 {
    public int findMinArrowShots(int[][] points) {
        int count = 1;
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int q = points[0][1];
        for (int[] point : points) {
            if (q < point[0]) {
                count++;
                q = point[1];
            }
        }
        return count;
    }
}
