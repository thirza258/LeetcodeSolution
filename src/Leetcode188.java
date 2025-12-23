import java.util.HashMap;

public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }

        int[][][] state = new int[prices.length + 1][k + 1][2];

        int n = prices.length;

        for(int day = 0; day <= n; day++) {
            for(int transactionsHappen = 0; transactionsHappen <= k; transactionsHappen++) {
                for(int holding = 0; holding <= 1; holding++) {
                    if(day == 0) {
                        if(transactionsHappen == 0 && holding == 0) {
                            state[day][transactionsHappen][holding] = 0;
                        } else {
                            state[day][transactionsHappen][holding] = Integer.MIN_VALUE;
                        }
                    }
                    else {
                        if(holding == 0) {
                            int doNothingProfit = state[day - 1][transactionsHappen][0];
                            int sellProfit = state[day - 1][transactionsHappen][1];

                            if(sellProfit == Integer.MIN_VALUE) {
                                state[day][transactionsHappen][0] = doNothingProfit;
                            } else {
                                state[day][transactionsHappen][0] = Math.max(doNothingProfit, sellProfit + prices[day - 1]);
                            }

                        } else {
                            if(transactionsHappen == 0) {
                                state[day][transactionsHappen][1] = Integer.MIN_VALUE;
                                continue;
                            }

                            int doNothingProfit = state[day - 1][transactionsHappen][1];
                            int buyProfit = state[day - 1][transactionsHappen - 1][0];

                            if(buyProfit == Integer.MIN_VALUE) {
                                state[day][transactionsHappen][1] = doNothingProfit;
                            } else {
                                state[day][transactionsHappen][1] = Math.max(doNothingProfit, buyProfit - prices[day - 1]);
                            }
                        }
                    }

                }
            }
        }

        int maxProfit = 0;
        for (int i = 0; i <= k; i++) {
            maxProfit = Math.max(maxProfit, state[n][i][0]);
        }
        return maxProfit;
    }
}
