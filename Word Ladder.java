public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord==null || endWord==null)
            return 0;
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordList.remove(beginWord);
        int length = 1;

        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String curr = queue.poll();
                for (int j = 0; j < curr.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == curr.charAt(j)) {
                            continue;
                        }
                        String temp = replace(curr, j, c);
                        if (temp.equals(endWord)) {
                            return length + 1;
                        }
                        if (wordList.contains(temp)) {
                            queue.offer(temp);
                            wordList.remove(temp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
