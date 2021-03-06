public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] opt = new int[m][n];
        for (int i = 0; i < m; i++) {
            opt[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            opt[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j] = opt[i-1][j] + opt[i][j-1];
            }
        }
        return opt[m-1][n-1];
    }
}
