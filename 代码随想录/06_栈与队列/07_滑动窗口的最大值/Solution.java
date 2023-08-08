import java.util.LinkedList;

// https://leetcode.cn/problems/sliding-window-maximum/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> q = new LinkedList<>(); // 队列中存下标
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            // 队列头节点是最先放进来的, 需要检查在 [i - k + 1, i] 范围内
            if (!q.isEmpty() && i - k + 1 > q.peek()) q.poll();
            // 单调队列, 保证每次进去的数字比末尾的大
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast();
            q.offer(i);
            // 当 i 符合 k 范围的时候, 每次队列头节点放入结果
            if (i >= k - 1) res[idx++] = nums[q.peekFirst()];
        }
        return res;
    }
}