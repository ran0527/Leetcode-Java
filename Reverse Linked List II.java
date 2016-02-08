/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        int i = 1;
        while(pre.next != null && i < m) {
            pre = pre.next;
            i++;
        }

        ListNode mNode = pre.next; // find the mth Node
        ListNode cur = mNode.next; // track the node after m
        while (cur != null && i < n) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            mNode.next = next;
            cur = next;
            i++;
        }
        return dummy.next;
    }
}
