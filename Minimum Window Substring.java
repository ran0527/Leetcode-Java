# Brute Force
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        String res = null;
        int tLen = t.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + tLen - 1; j < s.length(); j++) {
                if (helper(s, t, i, j)) {
                    String tempStr = s.substring(i, j+1);
                    if (res == null || tempStr.length() < res.length()) {
                        res = tempStr;
                    }
                }
            }
        }
        return res == null ? "": res;
    }

    private boolean helper(String s, String t, int i, int j) {
        String subStr = s.substring(i, j+1);
        for (int k = 0; k < t.length(); k++) {
            if (subStr.indexOf(t.charAt(k)) == -1) {
                return false;
            }
        }
        return true;
    }
}

# Time: O(n)
public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (s == null || t == null) {
            return res;
        }
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (target.containsKey(t.charAt(i))) {
                target.put(t.charAt(i), target.get(t.charAt(i)) + 1);
            } else {
                target.put(t.charAt(i), 1);
            }
        }
        int start = 0;
        int count = 0;
        int minLen = s.length() + 1;
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (target.containsKey(c)) {
                if (found.containsKey(c)) {
                    if (found.get(c) < target.get(c)) {
                        count++;
                    }
                    found.put(c, found.get(c) + 1);
                } else {
                    found.put(c, 1);
                    count++;
                }
            }

            if (count == t.length()) {
                char sc = s.charAt(start);
                while (!found.containsKey(sc) || found.get(sc) > target.get(sc)) {
                    if (found.containsKey(sc) && found.get(sc) > target.get(sc)) {
                        found.put(sc, found.get(sc) - 1);
                    }
                    start++;
                    sc = s.charAt(start);
                }

                if (i - start + 1 < minLen) {
                    res = s.substring(start, i + 1);
                    minLen = i - start + 1;
                }
            }
        }
        return res;
    }
}
