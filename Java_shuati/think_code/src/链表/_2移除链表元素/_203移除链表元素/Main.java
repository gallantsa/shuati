package 链表._2移除链表元素._203移除链表元素;

public class Main {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1, head);

        for (ListNode p = dummy, q = head; q != null; q = q.next) {
            if(q.val == val) {
                p.next = q.next;
            } else {
                p = q;
            }
        }
        return dummy.next;
    }
}
