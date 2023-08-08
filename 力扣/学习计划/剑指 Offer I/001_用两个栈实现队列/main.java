import java.util.Stack;

class CQueue {
    Stack<Integer> inStack, outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void appendTail(int value) {
        inStack.push(value);
    }
    
    public int deleteHead() {
        if (!outStack.isEmpty())
            return outStack.pop();
        if (inStack.isEmpty())
            return -1;
        while (!inStack.isEmpty())
            outStack.push(inStack.pop());
        return outStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */