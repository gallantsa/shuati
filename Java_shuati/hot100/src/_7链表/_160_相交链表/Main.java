package _7链表._160_相交链表;

import _7链表.ListNode;

public class Main {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;

        // 两个链表的长度可能不一样，但是两个链表的长度之和是一样的
        // 当curA走到链表A的尾部时，curA指向链表B的头部
        // 当curB走到链表B的尾部时，curB指向链表A的头部
        // 此时curA和curB走过的长度是一样的，如果有相交的节点，那么curA和curB一定会在相交的节点相遇
        // 如果没有相交的节点，那么curA和curB一定会在null处相遇
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}