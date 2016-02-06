public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i <= nums.length; i++) {
            int start = i == 0 ? lower : nums[i - 1] + 1;
            int end = i == nums.length? upper : nums[i] - 1;
            getRanges(res, start, end);
        }
        return res;
    }

    private void getRanges(ArrayList<String> res, int start, int end) {
        if (start > end) {
            return;
        } else if (start == end) {
            res.add(start + "");
        } else {
            res.add(start + "->" + end);
        }
    }
}
