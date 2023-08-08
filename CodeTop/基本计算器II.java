package CodeTop;

import java.util.Stack;

// https://leetcode.cn/problems/basic-calculator-ii/
class Solution {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        char sign = '+'; // 上一个符号
        int num = 0; // 当前数字
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0') num = num * 10 - '0' + cur;
            if ((cur < '0' && cur != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+': numStack.push(num); break;
                    case '-': numStack.push(-num); break;
                    case '*': numStack.push(numStack.pop() * num); break;
                    case '/': numStack.push(numStack.pop() / num); break;
                }
                sign = cur;
                num = 0;
            }
        }

        int result = 0;
        while (!numStack.isEmpty()) result += numStack.pop();
        return result;
    }
}