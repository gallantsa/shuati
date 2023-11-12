package _7链表._2_两数相加;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        // 进位
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val = carry;
            if (l1 != null) {
                val += l1.val;
                // l1指向下一个节点
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                // l2指向下一个节点
                l2 = l2.next;
            }
            // 计算进位
            carry = val / 10;
            // 计算当前节点的值
            val = val % 10;
            // 将当前节点放到新链表中
            tail.next = new ListNode(val);
            // tail指向新链表的下一个节点
            tail = tail.next;
        }
        return head.next;
    }
}