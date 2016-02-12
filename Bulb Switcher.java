public class Solution {
    public int bulbSwitch(int n) {
        // int[] bulbs = new int[n];
        // for (int i = 1; i <= n; i++) {
        //     for (int j = i; j < n; j+=i) {
        //         bulbs[j] = 1 - bulbs[j];
        //     }
        // }
        // int res = 0;
        // for (int i = 0; i < n; i++) {
        //     res += bulbs[i];
        // }
        // return res;
        return (int) Math.sqrt(n);
    }
}
