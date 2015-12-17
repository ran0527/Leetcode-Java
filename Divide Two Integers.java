public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        long iDividend = Math.abs((long)dividend);
        long iDivisor = Math.abs((long)divisor);

        int res = 0;
        while (iDividend >= iDivisor) {
            int numShift = 0;
            while (iDividend >= (iDivisor << numShift)) {
                numShift++;
            }
            res += 1 << (numShift - 1);
            iDividend -= (iDivisor << (numShift - 1));
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return res;
        } else {
            return -res;
        }
    }
}
