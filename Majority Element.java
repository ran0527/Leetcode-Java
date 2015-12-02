public class Solution {
    public int majorityElement(int[] nums) {
        int majority_element = nums[0];
        int majority_times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority_element) {
                majority_times ++;
            } else if (majority_times == 0) {
                majority_times = 1;
                majority_element = nums[i];
            } else {
                majority_times--;
            }
        }
        return majority_element;
    }
}
