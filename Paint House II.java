public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int[][] opt = new int[m][n];

        // first row
        for (int i = 0; i < n; i++) {
            opt[0][i] = costs[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                opt[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        opt[i][j] = Math.min(opt[i][j], opt[i - 1][k] + costs[i][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, opt[m - 1][i]);
        }
        return min;
    }
}
