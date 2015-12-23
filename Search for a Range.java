public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int newLeft = 0;
        int newRight = nums.length - 1;
        while (newLeft <= newRight) {
            int newMid = (newLeft + newRight) / 2;
            if (nums[newMid] <= target) {
                newLeft = newMid + 1;
            } else {
                newRight = newMid - 1;
            }
        }
        if (left <= newRight) {
            res[0] = left;
            res[1] = newRight;
        }
        return res;
    }
}
