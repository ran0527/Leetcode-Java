public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String result = "1";
        int i = 1;
        while (i < n) {
            StringBuilder ans = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    ans.append(count);
                    ans.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            ans.append(count);
            ans.append(result.charAt(result.length() - 1));
            i++;
            result = ans.toString();
        }
        return result;
    }
}
