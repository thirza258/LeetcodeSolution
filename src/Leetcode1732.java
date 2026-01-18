public class Leetcode1732 {
    public int largestAltitude(int[] gain) {
        if(gain.length == 0) {
            return 0;
        }

        int maxAltitude = 0;
        int currentAltitude = 0;

        for(int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}
