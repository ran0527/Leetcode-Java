// Brute Force, LTE
public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!shareLetter(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private boolean shareLetter(String s1, String s2) {
        if (s1.length() > s2.length()) {
            for (char c: s2.toCharArray()) {
                if (s1.contains(c + "")) {
                    return true;
                }
            }
            return false;
        } else {
            for (char c: s1.toCharArray()) {
                if (s2.contains(c + "")) {
                    return true;
                }
            }
            return false;
        }
    }
}

// AC code
public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        int n = words.length;
        int[] elements = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                elements[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1 + 1; j < n; j++) {
                if ((elements[i] & elements[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
