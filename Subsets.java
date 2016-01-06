public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if (nums == null) {
            return res;
        }

        Arrays.sort(nums);
        helper(nums, 0, res, item);
        res.add(new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] nums, int start, ArrayList<List<Integer>> res, ArrayList<Integer> item) {
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            res.add(new ArrayList<Integer>(item));
            helper(nums, i + 1, res, item);
            item.remove(item.size() - 1);
        }
    }
}
