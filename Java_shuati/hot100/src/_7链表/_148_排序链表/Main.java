package _7链表._148_排序链表;

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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        // 当head.next == null时, 说明链表只有一个节点, 无需排序直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 找到链表的中间节点
        ListNode mid = findMid(head);
        // 将链表从中间节点处断开
        ListNode next = mid.next;
        // 断开链表
        mid.next = null;
        // 递归排序左右两个链表
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);

        return merge(left, right);
    }

    /**
     * 合并两个有序链表
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 合并两个有序链表
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        // 如果left链表不为空, 那么将left链表连接到cur后面
        if (left != null) {
            cur.next = left;
        }
        // 如果right链表不为空, 那么将right链表连接到cur后面
        if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }

    /**
     * 找到链表的中间节点的前一个节点
     * @param head
     * @return
     */
    private ListNode findMid(ListNode head) {
        if (head == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 这里找到的是中间节点的前一个节点
        return slow;
    }
}