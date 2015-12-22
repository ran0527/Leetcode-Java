public class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) {
             return;
         }
        k = k % nums.length;
        for (int i = 0; i < nums.length - k; i++) {
            res[i+k] = nums[i];
        }

        for (int i = nums.length - k; i < nums.length; i++) {
            res[i - nums.length + k] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
