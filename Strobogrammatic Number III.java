public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        ArrayList<String> res = new ArrayList<String>();
        for (int i = low.length(); i <= high.length(); i++) {
            res.addAll(helper(i, i));
        }
        for (String s: res) {
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) {
                continue;
            }
            count++;
        }
        return count;
    }

    private ArrayList<String> helper(int m, int n) {
        if (m == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (m == 1) {
            return new ArrayList<String>(Arrays.asList("0","1","8"));
        }
        ArrayList<String> cur = helper(m - 2, n);
        ArrayList<String> item = new ArrayList<String>();
        for (String s: cur) {
            if (m != n) {
                item.add("0" + s + "0");
            }
            item.add("1" + s + "1");
            item.add("6" + s + "9");
            item.add("8" + s + "8");
            item.add("9" + s + "6");
        }
        return item;
    }
}
