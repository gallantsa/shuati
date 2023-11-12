package _7链表._206_反转链表;

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
    public ListNode reverseList(ListNode head) {
        // 递归终止条件
        // 当链表为空或者链表只有一个节点时，直接返回
        // 如果链表不为空, 那么第一次返回的是链表的最后一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 递归调用
        ListNode newHead = reverseList(head.next);

        // 递归处理
        // 如果链表不为空, 那么第一次执行到这里时, head指向的是链表的倒数第二个节点
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}