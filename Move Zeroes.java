public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int m = j; m < nums.length; m++) {
            nums[m] = 0;
        }
    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
