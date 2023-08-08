/**
 * 快速幂：非递归
 */
class Solution {
    public double myPow(double x, int n) {
        // 处理 n < 0 情况
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double res = 1.0;
        while (n != 0) {
            // 最后一位为1，需要乘上该位的权重
            if ((n & 1) == 1)
                res*= x;
            x *= x;
            n >>= 1;
        }
        return res;
    }
}