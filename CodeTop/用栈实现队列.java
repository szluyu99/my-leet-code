package CodeTop;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stA;
    Stack<Integer> stB;

    public MyQueue() {
        stA = new Stack<>();
        stB = new Stack<>();
    }

    public void push(int x) {
        stA.push(x);
    }

    public int pop() {
        if (!stB.isEmpty()) return stB.pop();
        while (!stA.isEmpty()) stB.push(stA.pop());
        return stB.pop();
    }

    public int peek() {
        if (!stB.isEmpty()) return stB.peek();
        while (!stA.isEmpty()) stB.push(stA.pop());
        return stB.peek();
    }

    public boolean empty() {
        return stA.isEmpty() && stB.isEmpty();
    }
}