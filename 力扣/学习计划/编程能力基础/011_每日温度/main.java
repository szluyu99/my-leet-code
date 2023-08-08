import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 每日温度
 */
/**
 * 单调递减栈
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        // 单调递减栈(栈中存储的是下标)
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            // 当前元素 > 栈顶下标对应元素
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop(); // 获取栈顶下标
                res[temp] = i - temp; // 计算下标距离
            }
            stack.push(i); // 当前位置入栈
        }
        return res;
    }
}