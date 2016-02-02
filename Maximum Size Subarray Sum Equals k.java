public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = i + 1;
            }
            if (hm.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - hm.get(sum - k));
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return maxLen;
    }
}
