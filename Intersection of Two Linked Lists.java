/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        int lenA = 0;
        int lenB = 0;
        while (l1 != null) {
            lenA++;
            l1 = l1.next;
        }
        while (l2 != null) {
            lenB++;
            l2 = l2.next;
        }
        int diff = Math.abs(lenA - lenB);
        l1 = headA; l2 = headB;

        if (lenA > lenB) {
            int i = 0;
            while (i < diff) {
                l1 = l1.next;
                i++;
            }
        }
        if (lenA < lenB) {
            int i = 0;
            while (i < diff) {
                l2 = l2.next;
                i++;
            }
        }
        while (l1 != null && l2!= null) {
            if (l1.val == l2.val) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
}
