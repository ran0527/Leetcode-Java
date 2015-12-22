/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, sum - root.val, res, path);
        return res;
    }
    private void helper(TreeNode root, int sum, ArrayList<List<Integer>> res, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, sum - root.left.val, res, path);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, sum - root.right.val, res, path);
            path.remove(path.size()-1);
        }
    }
}
