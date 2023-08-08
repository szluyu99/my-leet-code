package CodeTop.LRU缓存;

import java.util.HashMap;

// 手写双向链表 (有虚拟头、尾节点)
class Node {
    public int key, value;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

class DList {
    private Node head, tail;
    private int size;

    public DList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点 x, O(1)
    public void addLast(Node x) {
        size++;
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
    }

    // 删除链表中的 x 节点 (x 一定存在)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中第一个节点, 并返回该节点, O(1)
    public Node removeFirst() {
        if (head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    DList cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);
        } else if (capacity == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, val);
    }

    // 将某个 key 提升为最近使用的
    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    // 删除某个 key
    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    // 添加最近使用的元素
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently() {
        // 链表头部第一个元素就是最久未使用的
        Node node = cache.removeFirst();
        map.remove(node.key);
    }
}
