public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] flagRow = new int[m];
        int[] flagCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    flagRow[i] = 1;
                    flagCol[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flagRow[i] == 1 || flagCol[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
