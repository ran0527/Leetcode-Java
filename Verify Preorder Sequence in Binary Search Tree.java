public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        int low = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < low) {
                return false;
            }
            while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                low = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}
