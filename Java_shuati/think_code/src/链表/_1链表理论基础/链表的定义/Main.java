package 链表._1链表理论基础.链表的定义;

public class Main {
}

class ListNode {
    // 节点的值
    int val;

    // 下一个结点
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
