/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode newSmallHead = small;
        ListNode big = new ListNode(0);
        ListNode newBigHead = big;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small= small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = newBigHead.next;
        return newSmallHead.next;
    }
}
