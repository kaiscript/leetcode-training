package leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 缓存容量  );
 * cache.put(1,1);
 * *cache.put(2,2);
 * *cache.get(1);       // 返回  1
 * *cache.put(3,3);    // 该操作会使得关键字 2 作废
 * *cache.get(2);       // 返回 -1 (未找到)
 * *cache.put(4,4);    // 该操作会使得关键字 1 作废
 * *cache.get(1);       // 返回 -1 (未找到)
 * *cache.get(3);       // 返回  3
 * *cache.get(4);       // 返回  4
 */
public class LRUCache {

    LRUNode head;
    LRUNode tail;
    int size;
    int capacity;
    public Map<Integer, LRUNode> cache = new HashMap<>();

    public class LRUNode {
        LRUNode pre;
        LRUNode next;
        int key;
        int val;

        public LRUNode() {
        }

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LRUNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            //将node移动到链表头部
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        LRUNode lruNode = cache.get(key);
        //不存在
        if (lruNode == null) {
            LRUNode node = new LRUNode(key, value);
            cache.put(key, node);
            addToHead(node);
            ++size;
            if (size > capacity) {
                LRUNode remove = removeTail();
                cache.remove(remove.key);
                size--;
            }
        }
        //存在则移动到头结点
        else{
            lruNode.val = value;
            moveToHead(lruNode);
        }

    }

    public void moveToHead(LRUNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 移除尾部
     * @return
     */
    public LRUNode removeTail() {
        LRUNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    /**
     * 将node移动到链表头部
     *
     * @param node
     */
    public void addToHead(LRUNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 移除节点
     * @param node
     */
    public void removeNode(LRUNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */