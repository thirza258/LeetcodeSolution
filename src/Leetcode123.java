import java.util.ArrayList;
import java.util.List;

public class Leetcode123 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int maxTransactions = 2;
        List<DPState> cache = new ArrayList<>();

        for(int day = 0; day <= n; day++) {
            for(int transactionsHappen = 0; transactionsHappen <= maxTransactions; transactionsHappen++) {
                for(int holding = 0; holding <= 1; holding++) {
                    DPState state = new DPState(day, transactionsHappen, holding);
                    cache.add(state);
                }
            }
        }


        for(int i = prices.length; i >= 0; i--) {
            for(int j = maxTransactions; j >= 0; j--) {
                for(int h = 0; h <= 1; h++) {
                    if(i == prices.length) {
                        DPState currentState = getState(cache, i, j, h, n, maxTransactions);
                        assert currentState != null;
                        currentState.addProfit(0);

                    } else if(j == maxTransactions) {
                        DPState currentState = getState(cache, i, j, h, n, maxTransactions);
                        assert currentState != null;
                        currentState.addProfit(0);
                    }
                    else {
                        if(h == 0) {
                            DPState currentState = getState(cache, i, j, h, n, maxTransactions);
                            DPState nextDayState = getState(cache, i + 1, j, 0, n, maxTransactions);
                            DPState buyState = getState(cache, i + 1, j, 1, n, maxTransactions);

                            assert currentState != null;
                            assert nextDayState != null;

                            int doNothingProfit = nextDayState.profit;
                            int buyProfit = buyState.profit - prices[i];
                            currentState.addProfit(Math.max(doNothingProfit, buyProfit));

                        } else  {
                            DPState currentState = getState(cache, i, j, h, n, maxTransactions);
                            DPState nextDayState = getState(cache, i + 1, j, 1, n, maxTransactions);
                            assert currentState != null;
                            assert nextDayState != null;
                            if(j+1 > maxTransactions) {
                                int doNothingProfit = nextDayState.profit;
                                currentState.addProfit(doNothingProfit);
                                continue;
                            }

                            DPState sellState = getState(cache, i + 1, j + 1, 0, n, maxTransactions);

                            assert sellState != null;

                            int doNothingProfit = nextDayState.profit;
                            int sellProfit = sellState.profit + prices[i];
                            currentState.addProfit(Math.max(doNothingProfit, sellProfit));
                        }
                    }
                }
            }
        }

        assert getState(cache, 0, 0, 0, n, maxTransactions) != null;
        return getState(cache, 0, 0, 0, n, maxTransactions).profit;
    }

    private DPState getState(List<DPState> cache, int day, int transactionsHappen, int holding, int n, int maxTransactions) {
        if(day > n || transactionsHappen > maxTransactions) {
            return null;
        }

        int index = day * (maxTransactions + 1) * 2 + transactionsHappen * 2 + holding;
        return cache.get(index);
    }
}

class DPState {
    int day;
    int transactionsHappen;
    int holding;

    int profit;
    public DPState(int day, int transactionsHappen, int holding) {
        this.day = day;
        this.transactionsHappen = transactionsHappen;
        this.holding = holding;
    }

    int addProfit(int profit) {
        this.profit = profit;
        return this.profit;
    }

}
