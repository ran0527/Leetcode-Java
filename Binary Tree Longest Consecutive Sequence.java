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
    private int longestLen = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0, root.val);
        return longestLen;
    }

    public void helper(TreeNode root, int count, int value) {
        if (root == null) {
            return;
        }
        if (root.val == value) {
            count += 1;
        } else {
            count = 1;
        }
        longestLen = Math.max(longestLen, count);
        helper(root.left, count, root.val + 1);
        helper(root.right, count, root.val + 1);
    }
}
