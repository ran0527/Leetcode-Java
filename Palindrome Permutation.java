public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s== null || s.length() == 0) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.remove(s.charAt(i));
            } else {
                hm.put(s.charAt(i), 1);
            }
        }
        if (hm.size() <= 1) {
            return true;
        }
        return false;
    }
}
