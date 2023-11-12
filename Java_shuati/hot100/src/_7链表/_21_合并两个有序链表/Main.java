package _7链表._21_合并两个有序链表;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            // 如果list1的值小于等于list2的值, 那么将list1的节点放到新链表中
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
                // 如果list1的值大于list2的值, 那么将list2的节点放到新链表中
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            // tail指向新链表的下一个节点
            tail = tail.next;
        }
        // 如果list1不为空, 那么将list1的剩余节点放到新链表中
        if (list1 != null) {
            tail.next = list1;
        }
        // 如果list2不为空, 那么将list2的剩余节点放到新链表中
        if (list2 != null) {
            tail.next = list2;
        }
        return head.next;
    }
}