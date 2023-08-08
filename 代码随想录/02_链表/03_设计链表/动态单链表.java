class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }
}

// 动态单链表
class MyLinkedList {
    int size; // 链表元素个数
    ListNode head; // 虚拟头节点

    // 初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // 获取第 index 个元素的值
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode cur = head; // 从头节点开始查找
        // 包含虚拟头节点, 所以查找第 index+1 个节点
        while (index-- >= 0) cur = cur.next;
        return cur.val;
    }

     // 在链表最前面插入一个节点
     public void addAtHead(int val) {
        addAtIndex(0, val);
    }

     // 在链表的最后插入一个节点
     public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点
    // 如果 index 为 0，那么新插入的节点为链表的新头节点
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        size++;
        // 找到要插入节点的前驱
        ListNode pre = head;
        while (index-- > 0) pre = pre.next;
        // 插入操作
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    // 删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pre = head;
        while (index-- > 0) pre = pre.next;
        pre.next = pre.next.next;
    }
}