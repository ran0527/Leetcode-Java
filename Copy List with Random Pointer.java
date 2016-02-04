/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 // Time O(n), Space O(n)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode newPointer = newHead;
        RandomListNode oldPointer = head.next;

        while (oldPointer != null) {
            RandomListNode newNode = new RandomListNode(oldPointer.label);
            map.put(oldPointer, newNode);
            newPointer.next = newNode;
            oldPointer = oldPointer.next;
            newPointer = newPointer.next;
        }
        oldPointer = head;
        newPointer = newHead;
        while (oldPointer != null) {
            newPointer.random = map.get(oldPointer.random);
            oldPointer = oldPointer.next;
            newPointer = newPointer.next;
        }
        return newHead;
    }
}
