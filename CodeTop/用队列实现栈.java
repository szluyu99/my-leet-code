package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/implement-stack-using-queues/
class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()) return 0;
        while (q1.size() > 1) q2.add(q1.poll());
        int result = q1.poll();
        while (!q2.isEmpty()) q1.add(q2.poll());
        return result; 
    }
    
    public int top() {
        if (q1.isEmpty()) return 0;
        while (q1.size() > 1) q2.add(q1.poll());
        int result = q1.peek();
        q2.add(q1.poll());
        while (!q2.isEmpty()) q1.add(q2.poll());
        return result;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}


class MyStack1 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack1() {

    }
    
    public void push(int x) {
        q1.add(x);
        while (!q2.isEmpty()) q1.add(q2.poll());
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    public int pop() {
        return q2.poll();
    }
    
    public int top() {
        return q2.peek();
    }
    
    public boolean empty() {
        return q2.isEmpty();
    }
}