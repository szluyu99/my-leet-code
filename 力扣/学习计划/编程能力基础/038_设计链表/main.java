/**
 * https://leetcode-cn.com/problems/design-linked-list/
 * 707. 设计链表
 */
class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node() {
            this.val = 0;
            this.next = null;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head; // 虚拟头结点
    Node tail; // 尾节点, 方便从最后插入

    public MyLinkedList() {
        this.head = new Node(); // 虚拟头节点
        this.tail = this.head; // 一开始没有尾节点
    }

    public int get(int index) {
        Node node = head.next;
        while (index > 0) {
            node = node.next;
            index--;
            if (node == null) return -1;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val, head.next);
        head.next = newNode;
        maintainTail();
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val, null);
        tail.next = newNode;
        maintainTail();
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val); // index <= 0, 直接往前面插入
            return;
        }
        Node node = head;
        while (index > 0) {
            node = node.next;
            index--;
            // index 大于链表长度, 不会插入节点
            if (node == null) return;
        }
        // index 等于链表长度, 在后面插入节点
        if (node.next == null) {
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val, node.next);
        node.next = newNode;
        maintainTail();
    }

    public void deleteAtIndex(int index) {
        if (index < 0) return;
        Node node = head;
        while (index > 0) {
            node = node.next;
            index--;
            if (node == null) return;
        }
        tail = node; // 需要维护一下尾节点, 直接删除有可能让 tail 乱掉
        if (node.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
        maintainTail();
    }

    // 维护尾节点
    void maintainTail() {
        while (tail.next != null) {
            tail = tail.next;
        }
    }
}