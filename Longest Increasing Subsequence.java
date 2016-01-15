public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] opt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            opt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    opt[i] = Math.max(opt[j] + 1, opt[i]);
                }
            }
        }
        int maxLen = opt[0];
        for (int i = 1 ; i < opt.length; i++) {
            maxLen = Math.max(maxLen, opt[i]);
        }
        return maxLen;
    }
}
