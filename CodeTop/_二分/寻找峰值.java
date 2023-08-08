package CodeTop._二分;

// https://leetcode.cn/problems/find-peak-element/
// 题目保证了相邻两个元素一定不相同，所以每次二分只有大于或小于的关系。
//（要么往更小的地方走，要么往更大的地方走） 无限往大的地方靠近，总能找到某个局部最高点（不一定是全居最高）。
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= nums[mid + 1])  r = mid;
            else l = mid + 1;
        }
        return l;
    }
}