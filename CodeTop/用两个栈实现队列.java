package CodeTop;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
class CQueue {
    Deque<Integer> st1;
    Deque<Integer> st2;

    public CQueue() {
        st1 = new ArrayDeque<>();
        st2 = new ArrayDeque<>();
    }
    
    public void appendTail(int value) {
        st1.push(value);
    }
    
    public int deleteHead() {
        if (!st2.isEmpty()) return st2.pop();
        if (st1.isEmpty()) return -1;
        while (!st1.isEmpty()) st2.push(st1.pop());
        return st2.pop();
    }
}