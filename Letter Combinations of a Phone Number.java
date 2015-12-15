public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        res.add("");
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            String letter = letters[digits.charAt(i) - '2'];
            ArrayList<String> temp = new ArrayList<String>();
            for (int j = 0; j < letter.length(); j++) {
               for (String s: res) {
                   s += letter.charAt(j);
                   temp.add(s);
               }
            }
            res = temp;
        }
        return res;
    }

}
