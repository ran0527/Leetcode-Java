public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.add(i);
                map.put(words[i], newList);
            }
        }

        int res = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            List<Integer> list = map.get(word1);
            for (int i = 1; i < list.size(); i++) {
                res = Math.min(list.get(i) - list.get(i - 1), res);
            }
            return res;
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0; int j = 0;
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if (index1 < index2) {
                res = Math.min(res, index2 - index1);
                i++;
            } else {
                res = Math.min(res, index1 - index2);
                j++;
            }
        }
        return res;
    }
}
