package CodeTop._数学;

// https://leetcode.cn/problems/powx-n/
// 递归
// 2^5 => 2^2 * 2^2 * 2^1
// 2^2 => 2^1 * 2^1 * 2^0
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }
}

class Solution1 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) {
            if (n % 2 == 0) return myPow(x * x, n / 2);
            else return x * myPow(x * x, (n - 1) / 2);
        } else return 1/x * myPow(1/x, -(n+1));
    }
}

// 迭代
class Solution2 {
    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                result *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / result : result;
    }
}