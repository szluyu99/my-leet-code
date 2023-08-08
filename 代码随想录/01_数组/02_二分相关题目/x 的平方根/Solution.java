// https://leetcode.cn/problems/sqrtx/
// 浮点数二分
class Solution {
    public int mySqrt(int x) {
        double l = 1, r = x;
        while (r - l > 1e-6) { // 设置一个精度
            double mid = (l + r) / 2;
            if (mid * mid <= x) l = mid;
            else r = mid;
        }
        return (int) r;
    }
}

// 整数二分
class Solution1 {
    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid < x / mid) l = mid + 1;
            else if (mid > x / mid) r = mid - 1;
            else return mid;
        }
        return r;
    }
}