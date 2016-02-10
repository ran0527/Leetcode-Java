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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode p, int[] count) {
        if (p == null) {
            return true;
        }
        boolean left = helper(p.left, count);
        boolean right = helper(p.right, count);
        if (left && right) {
            if (p.left != null && p.val != p.left.val) {
                return false;
            }
            if (p.right != null && p.val != p.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
