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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode p, Integer max, Integer min) {
        if (p == null) {
            return true;
        }
        if ((min != null && p.val <= min) || (max != null &&p.val >= max)) {
            return false;
        }
        return helper(p.left, p.val, min) && helper(p.right, max, p.val);
    }
}

# 2
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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean helper(TreeNode p, long max, long min) {
        if (p == null) {
            return true;
        }
        if ((p.val <= min) || (p.val >= max)) {
            return false;
        }
        return helper(p.left, p.val, min) && helper(p.right, max, p.val);
    }
}
