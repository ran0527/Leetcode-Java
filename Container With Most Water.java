public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int mostWater = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            mostWater = Math.max(mostWater, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return mostWater;
    }
}
