/**
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * 693. 交替位二进制数
 */
class Solution {
    /**
     * toBinaryString + 遍历
     */
    public boolean hasAlternatingBits(int n) {
        String binStr = Integer.toBinaryString(n);
        for (int i = 1; i < binStr.length(); i++)
            if (binStr.charAt(i - 1) == binStr.charAt(i))
                return false;
        return true;
    }

    /**
     * 迭代 + 位运算
     */
    public boolean hasAlternatingBits1(int n) {
        // 记录数字最后一位的二进制数
        int flag = n & 1;
        while (n != 0) {
            if ((n & 1) != flag)
                return false;
            n >>= 1;
            flag = (flag == 1) ? 0 : 1;
        }
        return true;
    }

    /**
     * 迭代 + 位运算(优化)
     */
    public boolean hasAlternatingBits11(int n) {
        while (n > 0) {
            if ((n & 1) == (n >> 1 & 1))
                return false;
            n >>= 1;
        }
        return true;
    }

    /**
     * 存在 00 或 11 则不满足条件
     */
    public boolean hasAlternatingBits2(int n) {
        String binStr = Integer.toBinaryString(n);
        return !binStr.contains("00") && !binStr.contains("11");
    }

    /**
     * 巧妙位运算
     */
    public boolean hasAlternatingBits3(int n) {
        // 如果 n 是交替的 01, 那么 n ^ (n >> 1) 必然全为1
        // 5 = 101
        // 5 >> 1 = 10
        // 5 ^ (5 >> 1) = 111
        int m = n ^ (n >> 1);
        // 全为 1 的二进制位 + 1 后会进位
        // 111 + 1 > 1000
        // 111 & 1000 等于 0
        return (m & m + 1) == 0;
    }

}