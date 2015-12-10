public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] countTable = new int[256];
        Arrays.fill(countTable, -1);
        int res = 1;
        int start = 0;
        int end = 1;

        countTable[s.charAt(0)] = 0;
        while (end < s.length()) {
            if (countTable[s.charAt(end)] >= start) {
                start = countTable[s.charAt(end)] + 1;
            }
            res = Math.max(res, end - start + 1);
            countTable[s.charAt(end)] = end;
            end++;
        }
        return res;
    }
}
