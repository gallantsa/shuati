package _7链表._141_环形链表;

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
    public boolean hasCycle(ListNode head) {

        // 1. 定义快慢指针
        ListNode slow = head, fast = head;

        // 2. 快慢指针同时出发
        // 进入循环的条件是快指针不为null并且快指针的下一个节点也不为null, 也就是说明链表至少有两个节点
        // fast != null 说明链表不为空
        // fast.next != null 说明链表至少有两个节点
        while (fast != null && fast.next != null) {

            // 3. 慢指针走一步
            slow = slow.next;

            // 4. 快指针走两步
            fast = fast.next.next;

            // 5. 如果快慢指针相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }

        // 6. 如果快指针走到了null处，说明没有环
        return false;
    }
}
