package CodeTop._字符串;

// https://leetcode.cn/problems/string-to-integer-atoi/
class Solution {
    public int myAtoi(String s) {
        long result = 0;
        int symbol = 0;

        // 处理空格
        s = s.trim();
        if (s.length() == 0) return 0;

        // 符号
        if (Character.isDigit(s.charAt(0))) symbol = 1;
        for (char c : s.toCharArray()) {
            // 符号
            if (symbol != 0 && !Character.isDigit(c)) return symbol * (int) result;
            if (c == '-') symbol = -1;
            if (c == '+') symbol = 1;

            // 计算值
            if (Character.isDigit(c)) result = result * 10 + (c - '0');

            // 溢出判断
            if (result * symbol > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * symbol < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int)(symbol * result);
    }
}