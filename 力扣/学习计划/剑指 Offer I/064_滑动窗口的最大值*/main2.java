import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列实现单调队列
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 队列按从大到小放入
        // 如果首位值（即最大值）不在窗口区间，删除首位
        // 如果新增的值小于队列尾部值，加到队列尾部
        // 如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
        // 如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
        if (nums.length == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        // 未形成窗口
        for (int i = 0; i < k; i++) {
            // 队列不为空时, 当前值与队列尾部值比较, 大于则删除队尾值
            // 循环删除直到队列中的值都大于当前值, 或者删到队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            // 执行完上面的循环后, 队列中要么为空, 要么值都比当前值大, 把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        // 窗口已经形成
        res[idx++] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            // i - k 已经在区间外, 如果首位等于 nums[i-k] 则删除
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            // 删除队列中比当前值大的值
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            // 将当前值添加到队列中
            deque.addLast(nums[i]);
            res[idx++] = deque.peekFirst();
        }

        return res;
    }
}