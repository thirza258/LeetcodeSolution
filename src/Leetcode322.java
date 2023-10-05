public class Leetcode322 {
    int [][] dp = new int[13][10001];

    public int coinChange(int[] coins, int amount) {
        for(int i=0;i<13;i++) {
            for(int j=0;j<10001;j++) {
                dp[i][j] = -1;
            }
        }
        int n = coins.length;
        int answer = helper(coins, amount, n);
        if(answer == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return answer;
    }

    public int helper(int[] coins, int amount, int n) {
        if(n <= 0 || amount <= 0) {
            if(amount == 0) {
                return 0;
            }
            return Integer.MAX_VALUE - 1;
        }
        if(dp[n][amount] != -1) {
            return dp[n][amount];
        }

        if(coins[n - 1] <= amount) {
            return dp[n][amount] = Math.min(1 + helper(coins, amount - coins[n-1], n), helper(coins, amount, n-1));
        }
        else {
            dp[n][amount] = helper(coins, amount, n-1);
            return dp[n][amount];
        }
    }

    public static void main(String[] args) {
        Leetcode322 lc = new Leetcode322();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(lc.coinChange(coins, amount));
    }
}
