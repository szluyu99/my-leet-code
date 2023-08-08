import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * 暴力
 */
class MaxQueue {
    Deque<Integer> queue;

    public MaxQueue() {
        queue = new LinkedList<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : queue.stream().max((o1, o2) -> o1 - o2).get();
    }

    public void push_back(int value) {
        queue.addLast(value);
    }

    public int pop_front() {
        return queue.isEmpty() ? -1 : queue.removeFirst();
    }
}
