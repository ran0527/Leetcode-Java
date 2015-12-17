public class Solution {
    public void nextPermutation(int[] nums) {
        int m = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                m = i;
                break;
            }
        }
        int n = 0;
        for (int i = nums.length - 1; i >= m; i--) {
            if (nums[i] > nums[m]) {
                n = i;
                break;
            }
        }
        if (m == 0 && n == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;

        if (m < nums.length - 1) {
            reverse(nums, m + 1, nums.length - 1);
        }
    }
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
