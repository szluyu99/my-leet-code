import java.util.Stack;

// https://leetcode.cn/problems/implement-queue-using-stacks/
class MyQueue {
    Stack<Integer> a, b;
    
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }
    
    public void push(int x) {
        a.push(x);
    }
    
    public int pop() {
        if (!b.isEmpty()) return b.pop();
        while (!a.isEmpty()) b.push(a.pop());
        return b.pop();
    }
    
    public int peek() {
        if (!b.isEmpty()) return b.peek();
        while (!a.isEmpty()) b.push(a.pop());
        return b.peek();
    }
    
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}

// 数组模拟队列
class MyQueue1 {
    int[] q = new int[10];
    int hh = 0, tt = -1;
    
    public MyQueue1() {}
    
    public void push(int x) {
        q[++tt] = x; 
    }
    
    public int pop() {
        return q[hh++];
    }
    
    public int peek() {
        return q[hh];
    }
    
    public boolean empty() {
        return hh > tt;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */