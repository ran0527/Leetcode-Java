// Time O(nlpgn), Space O(n)
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        int len = nums.length;

        int[] temp = new int[len];
        int left = (len - 1) / 2;
        int right = len - 1;

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                temp[i] = nums[left];
                left --;
            } else {
                temp[i] = nums[right];
                right--;
            }
        }
        System.arraycopy(temp, 0, nums, 0, len);
    }
}
