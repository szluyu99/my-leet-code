package CodeTop._双指针;

// https://leetcode.cn/problems/container-with-most-water/description/
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int result = 0;
        while (l < r) {
            int minH = Math.min(height[l], height[r]);
            result = Math.max(result, (r - l) * minH);
            while (l < r && height[l] <= minH) l++;
            while (l < r && height[r] <= minH) r--;
        }
        return result;
    }
}