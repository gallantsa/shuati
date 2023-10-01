package 类与接口.删除链表中重复的节点;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode deleteDuplication(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null) {
            ListNode q = p.next;
            while (q != null && p.next.val == q.val) q = q.next;
            if (p.next.next == q) p = p.next;
            else p.next = q;
        }

        return dummy.next;
    }
}
