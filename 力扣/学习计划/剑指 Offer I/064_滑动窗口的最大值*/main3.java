import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优先级队列
 * 每次删除需要维护队列，效率较低
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[] {};

        Queue<Integer> queue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        int left = 0, right = 0, idx = 0;
        int[] res = new int[nums.length - k + 1];
        while (right < nums.length) {
            queue.add(nums[right]);
            if (right - left + 1 == k) {
                res[idx++] = queue.peek();
                queue.remove(nums[left++]);
            }
            right++;
        }
        return res;
    }
}
