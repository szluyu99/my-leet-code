import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
// 优先队列
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小根堆
        for (int n : nums) pq.add(n);

        int res = 0;
        // 每次只将最小的值取反
        while (k-- > 0) pq.add(-pq.poll()); 
        while (!pq.isEmpty()) res += pq.poll();
        return res;
    }
}

// 模拟
class Solution1 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
  
        int idx = 0; // 遍历下标
        while (k-- > 0) { 
            // 当前数 < 0, 取反后和下一位进行比较
            if (idx < nums.length - 1 && nums[idx] < 0) {
                nums[idx] = -nums[idx]; // 取反
                //
                if (nums[idx] >= Math.abs(nums[idx + 1])) idx++;
                continue;
            }
            // 当前数 >= 0
            nums[idx] = -nums[idx]; // 取反
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) res += nums[i];
        return res;
    }
}