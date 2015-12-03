public class Solution {
    public int maxSubArray(int[] nums) {
        int opt = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            opt = Math.max(nums[i], opt + nums[i]);
            result = Math.max(result, opt);
        }
        return result;
    }
}
