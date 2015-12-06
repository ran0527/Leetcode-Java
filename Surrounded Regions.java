# dfs, overflow
public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        if (board[i][j] != 'O')
            return;

        board[i][j] = '1';

        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}

# bfs
public class Solution {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                bfs(board, i, n-1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                bfs(board, m-1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void bfs(char[][] board, int i, int j) {
        int n = board[0].length;

        fill(board, i ,j);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / n;
            int y = cur % n;

            fill(board, x-1, y);
            fill(board, x+1, y);
            fill(board, x, y-1);
            fill(board, x, y+1);
        }
    }
    private void fill(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i<0 || j<0 || i>=m || j>=n || board[i][j] != 'O') {
            return;
        }

        queue.offer(i * n + j);
        board[i][j] = '1';
    }
}
