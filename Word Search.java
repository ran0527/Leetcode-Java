public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int rowIndex, int colIndex, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        } else if (rowIndex < 0 || colIndex < 0 ||rowIndex >= board.length || colIndex >= board[0].length) {
            return false;
        } else if (visited[rowIndex][colIndex]) {
            return false;
        } else if (board[rowIndex][colIndex] != word.charAt(index)) {
            return false;
        } else {
            visited[rowIndex][colIndex] = true;
            boolean res = helper(board, word, rowIndex - 1, colIndex, index + 1, visited)
            || helper(board, word, rowIndex + 1, colIndex, index + 1, visited)
            || helper(board, word, rowIndex, colIndex - 1, index + 1, visited)
            || helper(board, word, rowIndex, colIndex + 1, index + 1, visited);
            visited [rowIndex][colIndex] = false;
            return res;
        }
    }
}Word Search.
