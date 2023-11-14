package _7链表._138_随机链表的复制;

import _7链表.Node;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // 本体思路:
    // 1. 遍历原链表, 将原链表的节点作为key, 新链表的节点作为value, 存入map中
    // 2. 再次遍历原链表, 通过map找到对应的新链表节点, 然后将新链表节点的next和random指针指向对应的节点
    // 3. 返回新链表的头节点
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        // 遍历原链表, 将原链表的节点作为key, 新链表的节点作为value, 存入map中
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }

        // 再次遍历原链表, 通过map找到对应的新链表节点, 然后将新链表节点的next和random指针指向对应的节点
        for (Node cur = head; cur != null; cur = cur.next) {
            // 通过map找到对应的新链表节点
            Node newNode = map.get(cur);
            // 将新链表节点的next和random指针指向对应的节点
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
        }

        // 返回新链表的头节点
        return map.get(head);
    }
}