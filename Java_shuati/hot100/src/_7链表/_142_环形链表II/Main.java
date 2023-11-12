package _7链表._142_环形链表II;

import _7链表.ListNode;

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
        ListNode slow = head, fast = head;
        // flag用来标记是否有环
        boolean flag = false;
        // 快慢指针同时出发
        while (fast != null && fast.next != null) {

            // 慢指针走一步
            // 快指针走两步
            fast = fast.next.next;
            slow = slow.next;

            // 如果快慢指针相遇，说明有环
            if (fast == slow) {
                // 标记有环
                flag = true;
                // 让快指针指向头节点
                fast = head;
                // 从相遇点和头节点同时出发，直到相遇
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                break;
            }
        }
        return flag ? fast : null;
    }
}