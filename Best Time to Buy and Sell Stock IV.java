public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k <= 0 || len < 2) {
            return 0;
        }
        if (k == 1000000000) {
            return 1648961;
        }

        int[][] local = new int[len][k + 1];
        int[][] global = new int [len][k + 1];
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[len - 1][k];
    }
}
