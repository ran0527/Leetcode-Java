public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return ;
        }
        // reverse whole sentence
        rotate(s, 0, s.length - 1);
        // reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                rotate(s, start, i - 1);
                start = i + 1;
            }
        }
        // in case of the sentence has only one word
        rotate(s, start, s.length - 1);
    }

    private void rotate(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
