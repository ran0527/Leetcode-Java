# Time: O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}

# Binary Search (TLE)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            for (int i = 0; i < numbers.length; i++) {
                int mid = left + (right - left) / 2;
                if ((target - numbers[i]) == numbers[mid]) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                } else if ((target - numbers[i]) < numbers[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
            }
            left++;
            right--;
        }
        return res;
    }
}

# 3
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        for (int i = 0; i < numbers.length; i++) {
            int index = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index != -1) {
                res[0] = i + 1;
                res[1] = index + 1;
                break;
            }
        }
        return res;
    }


    private int binarySearch(int[] numbers, int left, int right, int target) {
         while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
