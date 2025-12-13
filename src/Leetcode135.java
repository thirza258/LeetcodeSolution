import java.util.Arrays;

public class Leetcode135 {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }

        int result = 0;

        int[] candies = new int[ratings.length];

        for(int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }

        for(int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
        }

        for(int i = ratings.length - 2; i >= 0; i--) {
                if(ratings[i] > ratings[i + 1]) {
                    if (candies[i + 1] + 1 > candies[i]) {
                        candies[i] = candies[i + 1] + 1;
                    }
                }
        }

        for(int i = 0; i < ratings.length; i++) {
            result += candies[i];
        }

        return result;
    }
}
