public class Solution {
    public List<String> generateAbbreviations(String word) {
        ArrayList<String> res = new ArrayList<String>();
        helper(res, "", 0, word);
        return res;
    }

    private void helper(ArrayList<String> res, String cur, int start, String s) {
        // add the original string
        res.add(cur + s.substring(start));
        if (start == s.length()) {
            return;
        }
        // declare the new start point
        int i = 0;
        // except the first one, the start position should 1 from the last end point
        if (start > 0) {
            i = start + 1;
        }
        for (; i < s.length(); i++) {
            String pre = cur + s.substring(start, i);
            // start from the ith character, replace #j character to number
            for (int j = 1; j <= s.length() - i; j++) {
                helper(res, pre + j, i + j, s);
            }
        }
    }
}
