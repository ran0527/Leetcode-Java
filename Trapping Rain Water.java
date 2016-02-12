public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        // left --> right
        left[0] = height[0];
        int maxLeft = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(maxLeft, height[i]);
            maxLeft = Math.max(maxLeft, height[i]);
        }

        // right --> left
        right[height.length - 1] = height[height.length - 1];
        int maxRight = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(maxRight, height[i]);
            maxRight = Math.max(maxRight, height[i]);
        }

        // trapped water
        int total = 0;
        for (int i = 1; i < height.length; i++) {
            int bit = (Math.min(left[i], right[i]) - height[i]) * 1;
            total += bit;
        }
        return total;
    }
}
