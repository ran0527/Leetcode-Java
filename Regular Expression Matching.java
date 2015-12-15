public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            if (s.length() < 1) {
                return false;
            } else if (p.charAt(0) != s.charAt(0) && (p.charAt(0) != '.')) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            } else if (p.charAt(0) != s.charAt(0) && (p.charAt(0) != '.')) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        } else {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
                if (isMatch(s.substring(i+1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}

＃2
public class Solution {
    public boolean isMatch(String s, String p) {
        // 都用完
        if (p.length() == 0) {
            return s.length() == 0;
        } else if (p.length() < 2 || p.charAt(1) != '*') { // pattern 不带*
            if (s.length() == 0) { // pattern 用完了， s没有match完
                return false;
            } else if (!isMatchChar(s, p, 0, 0)) { // 第一位就不match
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        } else { // pattern 带 *
            for (int i = 0; i <= s.length(); i++) { // length + 1种match
                if (i == 0 || isMatchChar(s, p, i-1, 0)) { // 能对上pattern a*的a
                    if (isMatch(s.substring(i), p.substring(2))) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public boolean isMatchChar(String s, String p, int i, int j) {
        return (s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.');
    }
}
