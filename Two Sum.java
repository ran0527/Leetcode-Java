# Time O(n^2), Space O(1)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
}

# Time O(n), Space O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.get(target - nums[i]) != null) {
                int index_1 = dict.get(target - nums[i]);
                int index_2 = i + 1;
                return new int[]{index_1, index_2};
            }
            dict.put(nums[i], i+1);
        }
        return new int[]{-1, -1};
    }
}
