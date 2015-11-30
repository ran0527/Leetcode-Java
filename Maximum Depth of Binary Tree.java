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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_child_depth = maxDepth(root.left);
        int right_child_depth = maxDepth(root.right);
        return Math.max(left_child_depth, right_child_depth) + 1;
    }
}
