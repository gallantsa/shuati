package 链表._8环形链表II._142环形链表II;

import 链表.ListNode;

public class Main {
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode index1, index2;
        while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            if (fast == slow){
                index1 = fast;
                index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}