public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] res = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i+1);
            if (wordDict.contains(word)) {
                res[i] = true;
            } else {
                res[i] = false;
                for (int j = 0; j< i; j++) {
                    if (res[j] && wordDict.contains(s.substring(j+1, i+1))) {
                        res[i] = true;
                        break;
                    }
                }
            }
        }
        return res[s.length()-1];
    }
}
