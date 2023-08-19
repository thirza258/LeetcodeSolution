public class Leetcode122 {
    public int maxProfit(int[] prices) {
        int maximum = 0;
        int minimum = Integer.MIN_VALUE;
        int pricesLength = prices.length;

        for(int i = 0; i < pricesLength - 1; i++) {
            // ketika menenumukan harga yang rendah maka akan dianggap sebagai harga minimum
            // dan lanjutkan mencari harga yang lebih tinggi
            if(prices[i] < prices[i+1] && minimum < 0) {
                minimum = i;
            }

            // ketika menemukan harga yang tinggi maka akan dianggap sebagai harga maksimum
            if(prices[i] > prices[i+1] && minimum >= 0) {
                maximum += (prices[i] - prices[minimum]);
                minimum = Integer.MIN_VALUE;
            }
        }

        if(minimum >= 0) {
            maximum += (prices[pricesLength - 1] - prices[minimum]);
        }

        return maximum;
    }

    public static void main(String[] args) {
        Leetcode122 lc = new Leetcode122();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(lc.maxProfit(prices));
    }
}
