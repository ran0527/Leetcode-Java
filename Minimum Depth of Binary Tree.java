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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (minLeft == 0 || minRight == 0) {
            return minLeft >= minRight? minLeft + 1: minRight + 1;
        }
        return Math.min(minLeft, minRight) + 1;
    }
}
