package _7链表._25_K个一组翻转链表;

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
// 上一题的进阶版
// 模拟一遍就懂了
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a, b;
        a = b = head;
        // 如果剩余节点不足k个, 那么直接返回
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }

        // 反转[a, b)之间的节点
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        // 返回新的头节点
        return newHead;
    }

    /**
     * 反转链表[a, b)之间的节点
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // 反转[a, b)之间的节点
        while (cur != b) {
            // 保存下一个节点
            nxt = cur.next;
            // 反转当前节点
            cur.next = pre;
            // 更新pre和cur
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}