public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        helper(s, "", res, 0);
        return res;
    }

    private void helper(String s, String temp, ArrayList<String> res, int count) {
        if (count == 3 && isValid(s)) {
            res.add(temp + s);
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (isValid(sub)) {
                helper(s.substring(i), temp + sub + '.', res, count + 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num > 0 && num <= 255;
    }
}
