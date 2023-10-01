package 类与接口.反转链表;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next)
            n++;
        int[] ints = new int[n];
        int i = n - 1;
        for (ListNode p = head; p != null; p = p.next)
            ints[i--] = p.val;
        i = 0;
        for (ListNode p = head; p != null; p = p.next)
            p.val = ints[i++];
        return head;
    }
}