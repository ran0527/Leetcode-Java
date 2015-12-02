public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }

        int element_1 = nums[0];
        int element_2 = 0;
        int count_1 = 1;
        int count_2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == element_1) {
                count_1++;
            } else if (nums[i] == element_2) {
                count_2++;
            } else if (count_1 == 0) {
                count_1 = 1;
                element_1 = nums[i];
            } else if (count_2 == 0) {
                count_2 = 1;
                element_2 = nums[i];
            } else {
                count_1--;
                count_2--;
            }
        }
        count_1 = 0; count_2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element_1) {
                count_1++;
            } else if (nums[i] == element_2) {
                count_2++;
            }
        }
        if (count_1 > nums.length/3) {
            res.add(element_1);
        }
        if (count_2 > nums.length/3) {
            res.add(element_2);
        }
        return res;
    }
}
