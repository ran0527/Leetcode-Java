public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        if (needle.length() == 0) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i < m; i++) {
            if (i + n > m) {
                return -1;
            }
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i+j) == needle.charAt(j)) {
                    if (j == n-1) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
