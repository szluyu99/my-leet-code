import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 * 最近的请求次数
 */
class RecentCounter {
    LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.addLast(t);
        while (queue.getFirst() < t - 3000) {
            queue.removeFirst();
        }
        return queue.size();
    }
}
