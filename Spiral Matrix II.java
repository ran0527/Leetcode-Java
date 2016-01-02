public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) {
            return res;
        }
        int start = 1;
        int top = 0; int bottom = n - 1; int left = 0; int right = n - 1;
        while (top < bottom && left < right) {
            // matrix of top
            for (int i = left; i < right; i++) {
                res[top][i] = start++;
            }
            // matrix of right
            for (int i = top; i < bottom; i++) {
                res[i][right] = start++;
            }
            // matrix of bottom
            for (int i = right; i > left; i--) {
                res[bottom][i] = start++;
            }
            // matrix of left
            for (int i = bottom; i > top; i--) {
                res[i][left] = start++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        if (n % 2 != 0) {
            res[n/2][n/2] = start;
        }
        return res;
    }
}
