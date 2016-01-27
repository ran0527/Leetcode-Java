public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() < 1) {
            return res;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String s1 = s.substring(0, i);
                String s2 = "--";
                String s3 = s.substring(i + 2);
                String temp = s1 + s2 + s3;
                res.add(temp);
            }
        }
        return res;
    }
}
