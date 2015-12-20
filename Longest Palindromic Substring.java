＃1 Time O(n^3)
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int maxLength = 0;
        String longestPalidrome = null;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int len = j - i;
                String curr = s.substring(i, j + 1);
                if (isPalindrome(curr)) {
                    if (len > maxLength) {
                        longestPalidrome = curr;
                        maxLength = len;
                    }
                }
            }
        }
        return longestPalidrome;
    }
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

#2 Time O(n^2) Space O(1)
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1 || s == null) {
            return s;
        }
        String longestPalidrome = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String curr = helper(s, i, i);

            if (curr.length() > longestPalidrome.length()) {
                longestPalidrome = curr;
            }
            curr = helper(s, i, i + 1);
            if (curr.length() > longestPalidrome.length()) {
                longestPalidrome = curr;
            }
        }
        return longestPalidrome;
    }
    public String helper(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
