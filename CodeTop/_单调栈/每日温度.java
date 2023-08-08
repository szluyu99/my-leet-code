package CodeTop._单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/daily-temperatures/

// 单调递减栈
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}

// 暴力（超时）
class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{ 0 };
        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++ ) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}