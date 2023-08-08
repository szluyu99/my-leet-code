package CodeTop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

// https://leetcode.cn/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 当遇到右括号时去判断能否和栈顶内元素消掉
            if (c == ')' || c == ']' || c == '}') {
                if (stack.peekLast() == map.get(c)) {
                    stack.pollLast();
                    continue;
                }
            }
            stack.addLast(c);
        }

        return stack.isEmpty();
    }
}