public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (start = 0; start < nums.length; start++) {
            while (end < nums.length && sum < s) {
                sum += nums[end];
                end++;
            }
            if (sum >= s) {
                minLen = Math.min(minLen, end - start);
            }
            sum -= nums[start];
        }
        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        return minLen;
    }
}
