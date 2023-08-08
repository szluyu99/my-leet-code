class ListNode {
    int val;
    ListNode next, prev;

    ListNode(int x) {
        val = x;
    }
}

class MyLinkedList {
    int size;
    ListNode head, tail;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;

        // 索引 < 一半从前往后找, 索引 > 一半从后前找
        if (index < size / 2) {
            for (int i = 0; i <= index; i++) cur = cur.next;
        } else {
            cur = tail;
            for(int i = 0; i <= size - index - 1; i++) cur = cur.prev;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next =  newNode;
        newNode.prev = head;
        size++;
        // addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
        // addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        // 找到要添加的前驱
        ListNode pre = head;
        while (index-- > 0) pre = pre.next;
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next.prev = newNode;
        newNode.prev = pre;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;
        // 找到要删除的前驱
        ListNode pre = head;
        while (index-- > 0) pre = pre.next;
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
        size--;
    }
}