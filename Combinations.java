public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k <= 0 || n < k) {
            return res;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        helper(n, k, 1, res, ans);
        return res;
    }

    private void helper(int n, int k, int start, ArrayList<List<Integer>> res, ArrayList<Integer> ans) {
        if (ans.size() == k) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = start; i <= n; i++) {
            ans.add(i);
            helper(n, k, i + 1, res, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
