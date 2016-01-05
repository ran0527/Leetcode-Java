public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
