import java.util.Arrays;

public class Leetcode274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] >= citations.length - i && (i - 1 < 0 || citations[i-1] <= citations.length - i)) {
                hIndex = citations.length - i;
            }
        }
        return hIndex;
    }
}
