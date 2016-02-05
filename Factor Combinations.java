public class Solution {
    public List<List<Integer>> getFactors(int n) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), n, 2);
        return res;
    }

    private void helper(ArrayList<List<Integer>> res, ArrayList<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                res.add(new ArrayList<Integer>(item));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                helper(res, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
}
