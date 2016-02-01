public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();

        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);

            if (hm.containsKey(tempStr)) {
                hm.get(tempStr).add(strs[i]);
            } else {
                ArrayList<String> item = new ArrayList<String>();
                item.add(strs[i]);
                hm.put(tempStr, item);
            }
        }
        for (String key : hm.keySet()) {
                ArrayList<String> curr = hm.get(key);
                Collections.sort(curr);
                res.add(curr);
            }
        return res;
    }
}
