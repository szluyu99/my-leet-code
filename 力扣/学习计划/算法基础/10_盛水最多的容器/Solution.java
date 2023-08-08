// https://leetcode.cn/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1, res = 0;
        while (l < r) {
            res = Math.max(res, (r - l) * (Math.min(h[l], h[r])));
            if (h[l] < h[r]) l++;
            else r--;
        }
        return res;
    }
}

// 优化代码
class Solution1 {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1, res = 0;
        while (l < r) {
            int minH = Math.min(h[l], h[r]);
            res = Math.max(res, (r - l) * minH);
            while (l < r && h[l] <= minH) l++;
            while (l < r && h[r] <= minH) r--;
        }
        return res;
    }
}