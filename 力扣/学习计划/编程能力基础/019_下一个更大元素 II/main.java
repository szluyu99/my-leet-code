import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2; i++) {
            // 栈不为空, 且当前元素 > 栈顶下标对应的元素
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.getLast()])
                // 更新栈顶下标对应的结果
                res[stack.removeLast()] = nums[i % nums.length];
            stack.addLast(i % nums.length);
        }
        return res;
    }
}