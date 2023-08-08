/**
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 */
class Solution {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0)
            return 0;

        // 跳过 "+" "-" 并 判断符号
        int sign = 1;
        if (str.startsWith("+") && str.length() != 1) {
            sign = 1;
            str = str.substring(1);
        } else if (str.startsWith("-") && str.length() != 1) {
            sign = -1;
            str = str.substring(1);
        }

        // 判断第一个字符非法情况
        if (str.charAt(0) < '0' || str.charAt(0) > '9')
            return 0;

        // 转成数字
        int res = 0, boundary = Integer.MAX_VALUE / 10;
        for (char c : str.toCharArray()) {
            // 中间遇到非法字符, 直接跳出
            if (c < '0' || c > '9')
                break;
            // 剪枝, 超过范围, 提前返回
            if (res > boundary || (res == boundary && c > '7'))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c - '0');
        }
        return res * sign;
    }
}