package com.markus.algorithm.leetcode.lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: markus
 * @date: 2023/1/2 4:21 PM
 * @Description: Leetcode第146题 LRU缓存
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */

/**
 * LRU缓存的设计思想
 * 1. 维护一个有序的单链表
 * 2. 插入数据时分为两种情况
 * 2.1 当插入的数据已经出现在链表中时，那么遍历将该数据组删除调，并且将新插入的数据插入到链表的头部
 * 2.2 当插入的数据没有出现链表中时，又会出现两种情况
 * 2.2.1 当链表容量没有满的时候，直接将数据插入到链表的头部
 * 2.2.2 当链表容量已经满的时候，首先将链表尾部的数据删除掉，然后将待插入的数据插入到链表的头部
 */
public class LRUCache {

    class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final List<Node<Integer, Integer>> cache;

    /**
     * 记录每个key-value元素存在LRU中的位置
     */
    private Map<Integer, Integer> position = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ArrayList<>(capacity);
    }

    public int get(int key) {
        Integer pos = position.get(key);
        if (pos == null) {
            return -1;
        } else {
            // 使用过改key了 so 需要维护下链表结构
            Node node = cache.get(pos);
            cache.remove((int) pos);
            cache.add(0, node);
            resetPos();
            return (int) node.value;
        }
    }

    public void put(int key, int value) {
        Node<Integer, Integer> node = new Node<>(key, value);
        // 1. 元素是否已经存在在链表中
        boolean isExist = position.containsKey(key);
        if (isExist) {
            // 存在
            Integer pos = position.get(key);
            cache.remove((int) pos);
            cache.add(0, node);
        } else {
            // 不存在
            if (cache.size() == capacity) {
                // 容量已经满了
                cache.remove(capacity - 1);
            }
            cache.add(0, node);
        }
        resetPos();
    }

    private void resetPos() {
        position.clear();
        for (int i = 0; i < cache.size(); i++) {
            position.put(cache.get(i).key, i);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(1));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
    }
}
