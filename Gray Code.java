public class Solution {
    public List<Integer> grayCode(int n) {
        if (n==0) {
            List<Integer> res = new LinkedList<Integer>();
            res.add(0);
            return res;
        }
        List<Integer> res = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        for (int i = res.size() - 1; i >= 0; i--) {
            res.add(addNumber + res.get(i));
        }
        return res;
    }
}
