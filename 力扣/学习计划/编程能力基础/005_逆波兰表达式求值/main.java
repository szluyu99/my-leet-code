import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 逆波兰表达式求值
 */
class Solution {
    /**
     * 用栈模拟
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token))
                stack.push(stack.pop() + stack.pop());
            else if ("-".equals(token))
                stack.push(-stack.pop() + stack.pop());
            else if ("*".equals(token))
                stack.push(stack.pop() * stack.pop());
            else if ("/".equals(token)) {
                Integer num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 / num1);
            } else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    /**
     * 数组模拟
     */
    public int evalRPN1(String[] tokens) {
        int[] res = new int[tokens.length];
        int cur = 1;
        for (String token : tokens) {
            if ("/*-+".contains(token)) {
                int b = res[cur--], a = res[cur--];
                res[++cur] = calc(a, b, token);
            } else
                res[++cur] = Integer.parseInt(token);
        }
        return res[cur];
    }

    public int calc(int a, int b, String op) {
        if (op.equals("+"))
            return a + b;
        else if (op.equals("-"))
            return a - b;
        else if (op.equals("*"))
            return a * b;
        else if (op.equals("/"))
            return a / b;
        else
            return -1;
    }
}