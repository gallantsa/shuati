package _7链表._146_LRU缓存;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

// LRU介绍
// LRU是Least Recently Used的缩写，即最近最少使用，是一种常用的页面置换算法，大白话选择最久未使用的页面予以淘汰。
// 如果插入数据时，发现容器已满时，则先按照 LRU 规则淘汰一个数据，再将新数据插入，其中「插入」和「查询」都算作一次“使用”。
// 其中插入是put, 查询是get
// 双向链表 + 哈希表
// 使用「哈希表」来确保插入和查询的复杂度为 O(1)
// 使用「双向链表」维护一个「使用顺序」序列
// 我们期望当「新数据被插入」或「发生键值对查询」时，能够将当前键值对放到序列头部，这样当触发 LRU 淘汰时，只需要从序列尾部进行数据删除即可。
class LRUCache {

    /**
     * 双向链表节点
     */
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 缓存容量
     */
    int capacity;

    /**
     * 双向链表的虚拟头节点和虚拟尾节点
     */
    Node head;
    Node tail;

    /**
     * 哈希表, 用于存储key和对应的节点
     */
    Map<Integer, Node> map;

    /**
     * 使用双向链表和哈希表实现
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        // 初始化双向链表的虚拟头节点和虚拟尾节点
        // 因为题目要求key和value都是正整数, 所以虚拟头节点和虚拟尾节点的key和value都设置为-1
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail; // head -> tail
        tail.prev = head; // head <- tail
    }

    /**
     * 获取key对应的value, 如果key不存在, 返回-1
     * @param key
     * @return
     */
    public int get(int key) {
        // 如果key不存在, 返回-1
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        refresh(node);
        return node.value;
    }

    /**
     * 将key和value存入缓存
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            refresh(node);
        }
        else {
            node = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            addToHead(node);
            map.put(key, node);
        }
    }

    /**
     * 刷新node节点, 将node节点移动到头部
     * @param node
     */
    private void refresh(Node node) {
        deleteNode(node);
        addToHead(node);
    }

    /**
     * 将node节点添加到头部
     * @param node
     */
    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    /**
     * 删除node节点
     * @param node
     */
    private void deleteNode(Node node) {
        if (node == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */