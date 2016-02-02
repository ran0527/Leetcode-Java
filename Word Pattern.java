public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }

        HashMap<Character, String> hm = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            if (hm.containsKey(pattern.charAt(i))) {
                if (!hm.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }else if (hm.containsValue(strs[i])) {
                return false;
            }else {
                hm.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }
}
