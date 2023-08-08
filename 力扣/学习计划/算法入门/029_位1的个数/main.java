/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 位1的个数
 */
class Solution {
    /**
     * 位运算
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    /**
     * 模拟
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                count++;
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight11(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }

    /**
     * 字符串操作
     */
    public int hammingWeight2(int n) {
        String binStr = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binStr.length(); i++)
            if (binStr.charAt(i) == '1')
                count++;
        return count;
    }

}