public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        HashMap<List<Integer>, List<String>> map = new HashMap<List<Integer>, List<String>>();

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            List<Integer> curKey = new ArrayList<Integer>();
            for (int j = 1; j < s.length(); j++) {
                int offset = s.charAt(j) - s.charAt(j - 1);
                int gap = offset > 0 ? offset : 26 + offset;
                curKey.add(gap);
            }
            if (map.containsKey(curKey)) {
                List<String> temp = map.get(curKey);
                temp.add(s);
            } else {
                List<String> temp  = new ArrayList<String>();
                temp.add(s);
                res.add(temp);
                map.put(curKey, temp);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            List<String> item = res.get(i);
            Collections.sort(item);
        }
        return res;
    }
}
