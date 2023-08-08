import java.util.Map;
import java.util.Stack;

// https://leetcode.cn/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        var map = Map.of('(', ')', '[', ']', '{', '}');
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            // 左括号入栈
            if (map.containsKey(c)) st.push(c);
            // 右括号, 判断是否与栈顶匹配
            else if (st.isEmpty() || c != map.get(st.pop())) return false;
        }
        return st.isEmpty();
    }
}