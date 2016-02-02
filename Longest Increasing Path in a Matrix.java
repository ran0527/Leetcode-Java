public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int longestDis = 0;

        // dfs for each element in matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestDis = Math.max(longestDis, helper(matrix, memo, i, j, Integer.MAX_VALUE));
            }
        }
        return longestDis;
    }

    public int helper(int[][] matrix, int[][] memo, int i, int j, int max) {
        // check boundary
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= max) {
            return 0;
        }

        // check memo if visited
        if (memo[i][j] != 0) {
            return memo[i][j];
        } else {
            int cur = matrix[i][j];
            int left = helper(matrix, memo, i - 1, j, cur) + 1;
            int right = helper(matrix, memo, i + 1, j, cur) + 1;
            int up = helper(matrix, memo, i, j - 1, cur) + 1;
            int down = helper(matrix, memo, i, j + 1, cur) + 1;

            int tempLongest = Math.max(left, Math.max(right, Math.max(up, down)));
            memo[i][j] = tempLongest;
            return tempLongest;
        }
    }
}
