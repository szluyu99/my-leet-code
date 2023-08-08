// https://leetcode.cn/problems/valid-perfect-square/
// Java 源码二分
class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (num / mid > mid) l = mid + 1;
            else if (num / mid < mid) r = mid - 1;
            else return num % mid == 0;
        }
        return false;
    }
}

// y总二分
class Solution1 {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (num / mid <= mid) r = mid;
            else l = mid + 1;
        }
        return (num / l == l) && (num % l == 0);
    }
}