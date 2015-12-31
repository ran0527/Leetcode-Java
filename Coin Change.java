public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        final int INF = 0x7ffffffe;
        for (int i = 1; i <= amount; i++) {
            dp[i] = INF;
        }
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] + i <= amount) {
                    dp[coins[j] + i] = Math.min(dp[coins[j] + i], dp[i] + 1);
                }
            }
        }
        return dp[amount] == INF? -1: dp[amount];
    }
}
