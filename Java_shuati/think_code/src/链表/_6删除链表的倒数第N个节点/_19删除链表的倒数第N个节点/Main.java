package 链表._6删除链表的倒数第N个节点._19删除链表的倒数第N个节点;

import 链表.ListNode;

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


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1); // 因为涉及链表的删除所以设置虚拟头结点统一操作
        dummy.next = head;
        ListNode p = dummy;
        int i = 0;
        // 统计节点个数
        while (p.next != null) {
            i++;
            p = p.next;
        }
        p = dummy;
        n = i - n;
        while (n -- != 0) {
            p = p.next; // 找到要删除节点的前驱节点
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
