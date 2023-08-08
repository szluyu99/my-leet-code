package CodeTop;

import java.util.Stack;

// https://leetcode.cn/problems/min-stack/

// 单栈做法
class MinStack {
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }
    
    // 如果新来的值比之前的最小值小, 那么 push 它前把之前的最小值存一下
    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}


// 双栈做法
class MinStack2 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if (minStack.peek().equals(stack.pop())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
