

public class Leetcode121 {
    public static int maxProfit(int[] prices) {
        int maximum = 0;
        int minimum = prices[0];

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minimum) {
                minimum = prices[i];
            } else if (prices[i] - minimum > maximum) {
                maximum = prices[i] - minimum;
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        int profit = maxProfit(new int[]{2,4,1});
        System.out.println(profit);
    }
}
