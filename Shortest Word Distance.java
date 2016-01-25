public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int[] index = new int[]{-1, -1};
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index[0] = i;
            } else if (words[i].equals(word2)) {
                index[1] = i;
            } else {
                continue;
            }

            if (index[0] != -1 && index[1] != -1) {
                dis = Math.min(dis, Math.abs(index[1] - index[0]));
            }
        }
        return dis;
    }
}
