import java.util.HashMap;

public class Leetcode149 {
    public int maxPoints(int[][] points) {

        if(points == null || points.length == 0) {
            return 0;
        }

        int result = 1;

        for(int i = 0; i < points.length; i++) {
            HashMap<Slope, Integer> slopeCount = new HashMap<>();
            int maxPointOnLine = 0;
            int duplicatePoints = 0;
            for(int j = 0; j < points.length; j++) {


                if(j != i) {
                    if(points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                        duplicatePoints++;
                    } else {
                        int deltaY = points[j][1] - points[i][1];
                        int deltaX = points[j][0] - points[i][0];
                        if(deltaX < 0) {
                            deltaX = -deltaX;
                            deltaY = -deltaY;
                        }
                        if(deltaX == 0) {
                            deltaY = 1;
                        } else if(deltaY == 0) {
                            deltaX = 1;
                        } else {
                            int gcd = gcd(deltaY, deltaX);
                            deltaY /= gcd;
                            deltaX /= gcd;
                        }
                        Slope slope = new Slope(deltaY, deltaX);
                        slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                        maxPointOnLine = Math.max(maxPointOnLine, slopeCount.get(slope));
                    }
                }


            }
            result = Math.max(result, maxPointOnLine + duplicatePoints + 1);
        }

        return result;

    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

class Slope {
    int deltaY;
    int deltaX;

    public Slope(int deltaY, int deltaX) {
        this.deltaY = deltaY;
        this.deltaX = deltaX;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Slope)) return false;
        Slope s = (Slope) o;
        return deltaY == s.deltaY && deltaX == s.deltaX;
    }

    @Override
    public int hashCode() {
        return 31 * deltaY + deltaX;
    }
}
