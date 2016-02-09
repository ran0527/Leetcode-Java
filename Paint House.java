public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] opt = new int[costs.length + 1][3];
        opt[0][0] = 0;
        opt[0][1] = 0;
        opt[0][2] = 0;

        for (int i = 1; i <= costs.length; i++) {
            opt[i][0] = Math.min(opt[i - 1][1] + costs[i - 1][0], opt[i - 1][2] + costs[i - 1][0]);
            opt[i][1] = Math.min(opt[i - 1][0] + costs[i - 1][1], opt[i - 1][2] + costs[i - 1][1]);
            opt[i][2] = Math.min(opt[i - 1][0] + costs[i - 1][2], opt[i - 1][1] + costs[i - 1][2]);
        }
        return Math.min(opt[costs.length][0], Math.min(opt[costs.length][1], opt[costs.length][2]));
    }
}
