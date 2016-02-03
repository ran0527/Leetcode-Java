/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private TreeNode root;
    private Stack<TreeNode> stack;
    private TreeNode temp;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        this.temp = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || temp != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }

        TreeNode t = stack.pop();
        int result = t.val;
        temp = t.right;

        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
