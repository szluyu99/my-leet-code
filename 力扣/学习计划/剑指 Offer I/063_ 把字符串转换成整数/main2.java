/**
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * 迭代（优化）
 */
class Solution {
    public int strToInt(String str) {
        // 去前后空格
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;

        // sign 符号, start - 遍历开始位置
        int sign = 1, start = 1; 
        // 首个非空字符是 '0', 从 1 开始遍历
        if (chars[0] == '-') sign = -1;
        // 首个非空字符不为 '-' 和 '+', 从 0 开始 遍历
        else if (chars[0] != '+') start = 0;

        int res = 0, boundary = Integer.MAX_VALUE / 10;

        for (int i = start; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') break;
            // 如果当前 res > bounday, 则执行 res = res * 10 + (chars[i] - '0') 必然越界
            // 如果 res = bounday, 是否越界要根据最后一位加上的 字符 判断
            if (res > boundary || (res == boundary && chars[i] > '7'))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (chars[i] - '0');
        }
        return sign * res;
    }
}