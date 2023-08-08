import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    Deque<Integer> stack, minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.getLast())
            minStack.addLast(val);
        stack.addLast(val);
    }

    public void pop() {
        if (minStack.getLast().equals(stack.removeLast()))
            minStack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}