# Brute Force
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (profit < prices[j] - prices[i]) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }
}

# O(n) Dynamic Programming
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
}
