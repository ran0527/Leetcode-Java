public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x1 = 0; int y1 = 0;
        int x2 = m - 1; int y2 = n - 1;
        while (x1 <= x2 && y1 <= y2) {
            helper(matrix, res, x1++, y1++, x2--, y2--);
        }
        return res;
    }

    private void helper(int[][] matrix, ArrayList<Integer> res, int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            res.add(matrix[x1][i]);
        }
        for (int i = x1 + 1; i <= x2; i++) {
            res.add(matrix[i][y2]);
        }
        if (x1 == x2 || y1 == y2) {
            return;
        }
        for (int i = y2 - 1; i >= y1; i--) {
            res.add(matrix[x2][i]);
        }
        for (int i = x2 - 1 ; i > x1; i--) {
            res.add(matrix[i][y1]);
        }
    }
}
