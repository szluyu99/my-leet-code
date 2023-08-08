package CodeTop;

// https://leetcode.cn/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // 找出最高点
        int maxIndex = 0, maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxValue) {
                maxValue = height[i];
                maxIndex = i;
            }
        }

        // 分别从两边往最高点遍历: 如果下一个数比当前数小, 说明可以接到水
        int sum = 0;
        int tmpMax = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > tmpMax) tmpMax = height[i];
            else sum += (tmpMax - height[i]);
        }

        tmpMax = 0;
        for (int i = n - 1; i >= maxIndex; i--) {
            if (height[i] > tmpMax) tmpMax = height[i];
            else sum += (tmpMax - height[i]);
        }

        return sum;
    }
}