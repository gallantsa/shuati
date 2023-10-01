package 链表._3设计链表._707设计链表;
// Todo 设计链表
public class Main {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
//        int param_1 = obj.get(index);
//        obj.addAtHead(val);
//        obj.addAtTail(val);
//        obj.addAtIndex(index, val);
//        obj.deleteAtIndex(index);
    }
}

class MyLinkedList {

    int size;
    ListNode head;

    //单链表
    static private class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val=val;
        }
    }

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        size++;
        ListNode p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        ListNode node = new ListNode(val);
        node.next = p.next;
        p.next = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size --;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */