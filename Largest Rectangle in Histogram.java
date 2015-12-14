#1 Time Limit Exceeded
public class Solution {
    public int largestRectangleArea(int[] height) {
        int max_area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i; j < height.length; j++) {
                int area = (j - i + 1) * minHeight(height, i, j);
                max_area = Math.max(area, max_area);
            }
        }
        return max_area;
    }

    public int minHeight(int[] height, int i, int j) {
        int tempMin = height[i];
        for (int m = i+1; m <= j; m++) {
            if (height[m] < tempMin) {
                tempMin = height[m];
            }
        }
        return tempMin;
    }
}

#2 Time Limit Exceeded
public class Solution {
    public int largestRectangleArea(int[] height) {
        int max_area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int minHeight = height[i];
            for (int j = i; j < height.length; j++) {
                if (minHeight > height[j]) {
                    minHeight = height[j];
                }
                int area = (j - i + 1) * minHeight;
                max_area = Math.max(area, max_area);
            }
        }
        return max_area;
    }
}

#3 Stack
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int i = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, h[top] * (stack.isEmpty()? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
