package 类与接口.从尾到头打印链表;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
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
    public int[] printListReversingly(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next)
            n++;

        int[] res = new int[n];
        for (ListNode p = head; p != null; p = p.next)
            res[-- n] = p.val;

        return res;
    }
}
