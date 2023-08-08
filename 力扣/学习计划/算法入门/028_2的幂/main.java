/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 231. 2 的幂
 */
class Solution {
    /**
     * 模拟
     */
    public boolean isPowerOfTwo(int n) {
        int i = 0;
        while (Math.pow(2, i) <= n) {
            if (Math.pow(2, i) == n)
                return true;
            i++;
        }
        return false;
    }

    public boolean isPowerOfTwo0(int n) {
        int i = 0;
        double num = 1;
        while (num <= n) {
            if ((num = Math.pow(2, i)) == n)
                return true;
            i++;
        }
        return false;
    }

    /**
     * 位运算
     * 000100 & 000011 = 000000
     */
    public boolean isPowerOfTwo1(int n) {
        return (n <= 0) ? false : (n & (n - 1)) == 0;
    }
}