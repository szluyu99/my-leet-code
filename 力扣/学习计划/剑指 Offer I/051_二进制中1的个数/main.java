/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Solution {
    /**
     * API
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    /**
     * 逐位判断
     */
    public int hammingWeight1(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
    /**
     * 巧用 n&(n-1) 消去最右边的 1
     * 时间复杂度：O(m), m 为二进制数字 n 中 1 的个数
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
    /**
     * 转二进制字符串, 然后将 "0" 换成 ""，剩下的长度就是 "1" 的个数
     */
    public int hammingWeight3(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }

}