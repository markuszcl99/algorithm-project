package com.markus.algorithm.leetcode.lru;

/**
 * @author: markus
 * @date: 2023/1/2 8:43 PM
 * @Description: 优化版的LRU缓存 get put均为O(1)时间复杂度
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 设计思想：
 * 1. 采用HashMap快速查找节点
 * 2. 设计双向链表，在删除、插入节点上时间复杂度为O(1)
 */
public class LRUCacheOptimize {
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {
        // 头结点
        Node<K, V> head;
        // 尾结点
        Node<K, V> tail;

        public DoubleLinkedList() {
        }

        /**
         * 添加节点有几种场景
         * 1.
         *
         * @param newNode
         */
        public void addHeadNode(Node<K, V> newNode) {
            // 头结点插入
            if (tail == null) {
                // 尾结点为空，说明此前链表还没数据
                this.tail = newNode;
                this.head = tail;
            } else {
                // 链表已经有数据了 头部插入
                Node<K, V> historyHead = this.head;
                historyHead.prev = newNode;
                newNode.next = historyHead;
                this.head = newNode;
            }

        }

        /**
         * @param moveNode
         */
        public void moveNodToHead(Node<K, V> moveNode) {
            // 1. 首尾节点
            if (head == moveNode) {
                // 首节点，不需要移动了
                return;
            } else if (tail == moveNode) {
                // 尾结点，需要一些操作
                tail = moveNode.prev;
                tail.next = null;
            } else {
                // 2. 中间节点
                Node<K, V> prevNode = moveNode.prev;
                Node<K, V> nextNode = moveNode.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }

            Node<K, V> historyHead = head;
            moveNode.next = historyHead;
            historyHead.prev = moveNode;
            moveNode.prev = null;
            head = moveNode;
        }

        /**
         *
         */
        public Node<K, V> removeTailNode() {
            Node<K, V> node = tail;
            if (head == tail) {
                // 只有一个节点
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            return node;
        }
    }

    private Map<Integer, Node<Integer, Integer>> nodeMap = new HashMap<>();
    private DoubleLinkedList<Integer, Integer> doubleLinkedList = new DoubleLinkedList<>();
    private final int capacity;

    public LRUCacheOptimize(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("capacity must greater than zero!");
        }
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        Node<Integer, Integer> oldNode = nodeMap.get(key);
        if (oldNode != null) {
            oldNode.value = value;
            doubleLinkedList.moveNodToHead(oldNode);
        } else {
            Node<Integer, Integer> node = new Node<>(key, value);
            if (size() == capacity) {
                Node<Integer, Integer> removeNode = doubleLinkedList.removeTailNode();
                nodeMap.remove(removeNode.key);
            }
            doubleLinkedList.addHeadNode(node);
            nodeMap.put(node.key, node);
        }

    }

    public int get(int key) {
        Node<Integer, Integer> node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        doubleLinkedList.moveNodToHead(node);
        return node.value;
    }

    private int size() {
        return this.nodeMap.size();
    }

    public static void main(String[] args) {
        LRUCacheOptimize lruCacheOptimize = new LRUCacheOptimize(2);
        System.out.println(lruCacheOptimize.get(2));
        lruCacheOptimize.put(2, 6);
        System.out.println(lruCacheOptimize.get(1));
        lruCacheOptimize.put(1, 5);
        lruCacheOptimize.put(1, 2);
        System.out.println(lruCacheOptimize.get(1));
        System.out.println(lruCacheOptimize.get(2));
    }

    private void testDemo() {
        LRUCacheOptimize lruCache = new LRUCacheOptimize(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    private void testDemo1() {
        LRUCacheOptimize lruCacheOptimize = new LRUCacheOptimize(1);
        lruCacheOptimize.put(2, 1);
        System.out.println(lruCacheOptimize.get(2));
        lruCacheOptimize.put(3, 2);
        System.out.println(lruCacheOptimize.get(2));
        System.out.println(lruCacheOptimize.get(3));
    }
}
