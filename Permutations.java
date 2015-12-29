public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        helper(nums, res, path, visited);
        return res;
    }
    private void helper(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                helper(nums, res, path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
