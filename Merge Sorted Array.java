public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (n < 0 || (m >= 0 && nums1[m] > nums2[n])) {
                nums1[m + n + 1] = nums1[m];
                m--;
            } else {
                nums1[m + n + 1] = nums2[n];
                n--;
            }
        }
        return;
    }
}
