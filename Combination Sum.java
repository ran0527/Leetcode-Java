public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, item);
        return res;
    }
    private void helper(int[] candidates, int target, int start, ArrayList<List<Integer>> res, ArrayList<Integer> item) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            item.add(candidates[i]);
            int newTarget = target - candidates[i];
            helper(candidates, newTarget, i, res, item);
            item.remove(item.size() - 1);
        }
    }
}
