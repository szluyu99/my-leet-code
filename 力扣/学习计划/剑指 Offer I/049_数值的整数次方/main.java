/**
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * 暴力（无法通过）
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1; 

        double res = 1.0;
        if (n > 0) {
            for (int i = 0; i < n; i++)
                res *= x;
        }

        if (n < 0) {
            for (int i = 0; i > n; i--)
                res *= 1 / x;
        }

        return res;
    }
}