/**
 * https://leetcode-cn.com/problems/reverse-bits/submissions/
 * 颠倒二进制位
 */

class Solution {
    /**
     * API
     */
    public int reverseBits0(int n) {
        return Integer.reverse(n);
    }

    /**
     * 位运算
     */
    public int reverseBits(int n) {
        int res = 0;
        int i = 32;
        while (i-- > 0) {
            res <<= 1;
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }

}