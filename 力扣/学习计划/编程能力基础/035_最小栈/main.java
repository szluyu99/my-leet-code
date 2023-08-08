import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/min-stack/submissions/
 * 优先级队列
 */
class MinStack {
    Deque<Integer> stack;
    Queue<Integer> queue;

    public MinStack() {
        stack = new ArrayDeque<>();
        queue = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        queue.add(val);
    }
    
    public void pop() {
        queue.remove(stack.removeLast());
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return queue.peek();
    }
}