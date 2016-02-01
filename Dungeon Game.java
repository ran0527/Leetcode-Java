public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] opt = new int[m][n];

        opt[m - 1][n - 1] = Math.max(1, -dungeon[m - 1][n - 1] + 1);

        // init last column
        for (int i = m - 2; i >= 0; i--) {
            opt[i][n - 1] = Math.max(1, opt[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        // init last row
        for (int i = n - 2; i >= 0; i--) {
            opt[m - 1][i] = Math.max(1, opt[m - 1][i + 1] - dungeon[m - 1][i]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                opt[i][j] = Math.max(1, Math.min(opt[i + 1][j], opt[i][j + 1]) - dungeon[i][j]);
            }
        }
        return opt[0][0];
    }
}
