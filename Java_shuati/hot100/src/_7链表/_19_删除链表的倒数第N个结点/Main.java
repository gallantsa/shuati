package _7链表._19_删除链表的倒数第N个结点;

import _7链表.ListNode;

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

        // 创建一个虚拟头节点
        // 力扣链表题默认没有虚拟头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        // 快慢指针同时出发
        ListNode slow = dummyHead, fast = dummyHead;
        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时出发
        // 当快指针走到链表的最后一个节点时, 慢指针指向的是倒数第n+1个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除倒数第n个节点
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}