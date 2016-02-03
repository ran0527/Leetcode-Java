public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board.length != 9 || board[0].length != 9) {
            return;
        }
        sudokuHelper(board);
    }

    public boolean sudokuHelper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValidSudoku(board, i, j, num)) {
                            board[i][j] = num;
                            if (sudokuHelper(board)) {
                                return true;
                            } else {
                                // backtracking
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board, int i, int j, char c) {
        // check column
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) {
                return false;
            }
        }

        // check row
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        // check 3*3 matrix
        for (int row = i/3*3; row < i/3*3+3; row++) {
            for (int col = j/3*3; col < j/3*3+3; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
