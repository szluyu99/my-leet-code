import javax.swing.text.html.HTML;

/**
 * 快速幂：递归 
 */
class Solution {
    public double myPow(double x, int n) {
        // 递归出口
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;

        // 计算出 x^(n/2)
        // 则 x^n = x^(n/2) * x^(n/2)
        double half = myPow(x, n >> 1);
        half *= half;
        // 如果指数是奇数，由于是 2 倍的缩小，会遗漏一次乘 x
        return (n & 1) == 1 ? half * x : half;
    }
}