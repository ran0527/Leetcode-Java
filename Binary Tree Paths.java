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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        helper(root, String.valueOf(root.val), res);
        return res;
    }
    private void helper(TreeNode root, String path, ArrayList<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), res);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), res);
        }
    }
}
