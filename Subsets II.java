public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int len = 1; len <= nums.length; len++) {
            helper(nums, 0, len, res, item);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
    private void helper(int[] nums, int start, int len, ArrayList<List<Integer>> res, ArrayList<Integer> item) {
        if (item.size() == len) {
            if (!res.contains(item)) {
                res.add(new ArrayList<Integer>(item));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            helper(nums, i + 1, len, res, item);
            item.remove(item.size() - 1);
        }
    }
}
