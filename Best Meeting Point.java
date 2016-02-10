public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    list1.add(i);
                    list2.add(j);
                }
            }
        }
        Collections.sort(list2);
        int sum = 0;
        int mid1 = list1.get(list1.size() / 2);
        int mid2 = list2.get(list2.size() / 2);

        for (int x: list1) {
            sum += Math.abs(x - mid1);
        }
        for (int y: list2) {
            sum += Math.abs(y - mid2);
        }
        return sum;
    }
}
