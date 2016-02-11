public class Solution {
    public List<String> findStrobogrammatic(int n) {
        ArrayList<String> res = new ArrayList<String>();
        helper(res, n, n);
        return res;
    }

    private void helper(List<String> list, int n, int m) {
        if (n == 0) {
            list.add("");
            return;
        }
        if (n == 1) {
            list.add("0");
            list.add("1");
            list.add("8");
            return;
        }
        helper(list, n - 2, m);
        int size = list.size();
        int i = 0;
        while (i < size) {
            String cur = list.get(i);
            if (n != m) {
                list.add("0" + cur + "0");
            }
            list.add("1" + cur + "1");
            list.add("6" + cur + "9");
            list.add("8" + cur + "8");
            list.add("9" + cur + "6");
            list.remove(0);
            size--;
        }
    }
}

// 2
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int m, int n) {
        if (m == 0) {
            List<String> res = Arrays.asList("");
            return res;
        }
        if (m == 1) {
            List<String> res = Arrays.asList("0", "1", "8");
            return res;
        }
        List<String> cur = helper(m - 2, n);
        List<String> res = new ArrayList<String>();

        for (String s: cur) {
            if (m != n) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
