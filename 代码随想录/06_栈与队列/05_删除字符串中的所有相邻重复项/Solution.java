import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
// 栈模拟
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> st = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) st.pop();
            else st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}

// 字符串
class Solution1 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && c == sb.charAt(len - 1)) sb.deleteCharAt(len - 1);
            else sb.append(c);
        }
        return sb.toString();
    }
}