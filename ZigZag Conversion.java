public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int size = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                res.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int temp = j + size - 2 * i;
                    if (temp < s.length()) {
                        res.append(s.charAt(temp));
                    }
                }
            }
        }
        return res.toString();
    }
}
