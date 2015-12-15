public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) > 214748364) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
        
