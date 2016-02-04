// Recursion
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!(new String(c1)).equals(new String(c2))) {
            return false;
        }
        if (s1.length() == 1) {
            return true;
        }

        for (int i = 0; i < s1.length() - 1; i++) {
            String s11 = s1.substring(0, i + 1);
            String s12 = s1.substring(i + 1);
            String s21 = s2.substring(0, i + 1);
            String s22 = s2.substring(i + 1);

            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }
            // check traverse part
            s21 = s2.substring(0, s2.length() - i - 1);
            s22 = s2.substring(s2.length() - i - 1);
            if (isScramble(s11, s22) && isScramble(s12, s21)) {
                return true;
            }
        }
        return false;
    }
}
