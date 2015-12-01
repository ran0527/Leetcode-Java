public class Solution {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        char tArray[] = s.toCharArray();
        char sArray[] = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        int i = 0;
        while (i < sLength) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
