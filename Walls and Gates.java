public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int rows = rooms.length;
        int cols = rooms[0].length;
        boolean[][] visited = new boolean[rows][cols];
        // start from gate
        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, visited, 0, i, j);
                }
            }
        }
    }

    public void helper(int[][] rooms, boolean[][] visited, int distance, int i, int j) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }
        // visited
        if (visited[i][j] == true) {
            return;
        }
        // wall?
        if (rooms[i][j] == -1) {
            return;
        }
        // distance > current
        if (distance > rooms[i][j]) {
            return;
        }
        visited[i][j] = true;

        if (distance < rooms[i][j]) {
            rooms[i][j] = distance;
        }
        helper(rooms, visited, distance + 1, i - 1, j);
        helper(rooms, visited, distance + 1, i + 1, j);
        helper(rooms, visited, distance + 1, i, j - 1);
        helper(rooms, visited, distance + 1, i, j + 1);

        visited[i][j] = false;
    }
}
