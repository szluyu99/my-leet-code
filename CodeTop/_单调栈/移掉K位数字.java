package CodeTop._单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/remove-k-digits/
class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }   
}