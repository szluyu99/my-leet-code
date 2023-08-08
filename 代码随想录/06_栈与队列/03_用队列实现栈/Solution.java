import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/implement-stack-using-queues/
// 队列实现栈
class MyStack {
    // a - 输入队列, b - 输出队列
    Queue<Integer> a, b;

    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }
    
    public void push(int x) {
        a.offer(x);
        // 将 b 队列中元素全部转给 a
        while (!b.isEmpty()) a.offer(b.poll());
        // 交换 a 和 b, 使得 a 在没有 push() 时永远为空队列
        Queue<Integer> tmp = a;
        a = b;
        b = tmp;
    }
    
    public int pop() {
        return b.poll();
    }
    
    public int top() {
        return b.peek();
    }
    
    public boolean empty() {
        return b.isEmpty();
    }
}

// 数组模拟栈
class MyStack1 {
    int[] stk;
    int tt = -1;

    public MyStack1() {
        stk = new int[110];
    }
    
    public void push(int x) {
        stk[++tt] = x;
    }
    
    public int pop() {
        return stk[tt--];
    }
    
    public int top() {
        return stk[tt];
    }
    
    public boolean empty() {
        return tt < 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */