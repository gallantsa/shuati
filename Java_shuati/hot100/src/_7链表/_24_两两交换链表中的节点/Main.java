package _7链表._24_两两交换链表中的节点;

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
    public ListNode swapPairs(ListNode head) {
        // 递归终止条件
        // 如果链表为空或者链表只有一个节点, 那么直接返回
        if (head==null || head.next==null) return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode others = head.next.next;

        second.next = first;
        first.next = swapPairs(others);

        // 返回新的头节点
        return second;
    }
}