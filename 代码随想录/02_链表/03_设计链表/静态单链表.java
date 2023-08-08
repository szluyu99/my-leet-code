// https://leetcode.cn/problems/design-linked-list/
// 静态单链表
class MyLinkedList {
    final int N = 1010;
    int[] e = new int[N];
    int[] ne = new int[N];
    int h = 0; // 头节点
    int idx = 1; // 虚拟头节点
    int size = 0; // 长度

    public MyLinkedList() {}
    
    public int get(int k) {
        if (k < 0 || k >= size) return -1;
        int t = ne[h];
        while (k -- > 0) t = ne[t];
        return e[t];
    }
    
    public void addAtHead(int val) {
        e[idx] = val;
        ne[idx] = ne[h];
        ne[h] = idx++;
        size++;
    }
    
    public void addAtTail(int val) {
        int t = h;
        while (ne[t] != 0) t = ne[t];
        e[idx] = val;
        ne[idx] = ne[t];
        ne[t] = idx++;
        size++;
    }
    
    public void addAtIndex(int k, int val) {
        if (k <= 0) addAtHead(val);
        else if (k == size) addAtTail(val);
        else if (k > 0 && k < size) {
            k --;
            int t = ne[h];
            while (k -- > 0) t = ne[t];
            e[idx] = val;
            ne[idx] = ne[t];
            ne[t] = idx++;
            size++;
        }
    }
    
    public void deleteAtIndex(int k) {
        if (k < 0 || k >= size) return;
        int t = h;
        while (k -- > 0) t = ne[t];
        ne[t] = ne[ne[t]];
        size--;
    }
}