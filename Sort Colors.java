public class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> count_dict = new HashMap<Integer, Integer>();
        for (int n : nums) {
            Integer count = count_dict.get(n);
            if (count == null) {
                count_dict.put(n, 1);
            } else {
                count_dict.put(n, count + 1);
            }
        }

        int[] colors = {0, 1, 2};
        int k = 0;
        for (int color : colors) {
            Integer count = count_dict.get(color);
            count = (count == null ? 0 : count);
            for (int i = 0; i < count; i++) {
                nums[k++] = color;
            }
        }
    }
}
