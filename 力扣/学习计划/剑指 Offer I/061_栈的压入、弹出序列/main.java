import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * 模拟
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length < 1) return true;

        Stack<Integer> stack = new Stack<>();

        int p1 = 0, p2 = 0, idx = 0;
        while (p2 < popped.length && idx < pushed.length * 2) {
            while (!stack.isEmpty() && stack.peek() == popped[p2]) {
                stack.pop();
                p2++;
                continue;
            }
            if (p1 < pushed.length)
                stack.push(pushed[p1++]);
            idx++;
        }
        return stack.isEmpty();
    }
}