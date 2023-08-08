package CodeTop._数学;

// https://leetcode.cn/problems/reverse-integer/
// 字符串反转
class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder().append(x).reverse();
        int flag = 1;
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
            flag = -1;
        }
        long result = flag * Long.parseLong(sb.toString());
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return 0;
        return (int) result;
    }
}

// 数字
class Solution1 {
    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int)n == n ? (int)n : 0;
    }
}