package _7链表._234_回文链表;

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
    public boolean isPalindrome(ListNode head) {

            // 1. 找到链表的中间节点
            ListNode midNode = findMidNode(head);

            // 2. 反转链表的后半部分
            ListNode newHead = reverseList(midNode);

            // 3. 判断是否是回文链表
            ListNode cur1 = head, cur2 = newHead;
            while (cur1 != null && cur2 != null) {
                if (cur1.val != cur2.val) {
                    return false;
                }

                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return true;
    }

    /**
     * 反转链表
     * @param midNode
     * @return
     */
    private ListNode reverseList(ListNode midNode) {

        if (midNode == null || midNode.next == null) {
            return midNode;
        }

        ListNode newHead = reverseList(midNode.next);

        midNode.next.next = midNode;
        midNode.next = null;

        return newHead;
    }

    /**
     * 找到链表的中间节点
     * @param head
     * @return
     */
    private ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}