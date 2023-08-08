import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/evaluate-reverse-polish-notation/
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String s : tokens) {
            if ("+".equals(s)) st.push(st.pop() + st.pop());
            else if ("-".equals(s)) st.push(-st.pop() + st.pop());
            else if ("*".equals(s)) st.push(st.pop() * st.pop());
            else if ("/".equals(s)) {
                int num1 = st.pop(), num2 = st.pop();
                st.push(num2 / num1);
            } else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
}