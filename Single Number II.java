public class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    count[j]++;
                }
            }
        }
        int res = 0;
        for (int j = 0; j < 32; j++) {
           res |= ((count[j] % 3) << j);
        }
        return res;
    }
}
