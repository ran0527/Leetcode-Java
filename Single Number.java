public class Solution {
    public int singleNumber(int[] nums) {
        int p = nums[0];
        for (int i = 1; i < nums.length; i++) {
            p = p ^ nums[i];
        }
        return p;
    }
}
