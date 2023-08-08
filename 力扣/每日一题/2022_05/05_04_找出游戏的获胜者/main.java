import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * 1823. 找出游戏的获胜者
 */
class Solution {
    // List 模拟（需要删除节点）
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int idx = 0;
        while (list.size() > 1) {
            idx = (idx + k - 1) % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }
    // 队列模拟
    public int findTheWinner1(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) queue.add(i);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}