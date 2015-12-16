public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        String path = new String();

        recursive(res, path, n, n);
        return res;
    }
    public void recursive(ArrayList<String> res, String path, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(new String(path));
            return;
        }
        if (left > 0) {
            recursive(res, path + '(', left - 1, right);
        }
        if (right > 0) {
            recursive(res, path + ')', left, right - 1);
        }
    }
}
