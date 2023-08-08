package CodeTop._贪心;

// https://leetcode.cn/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxDistance = 0; // 能到达的最远距离
        for (int i = 0; i < n; i++) {
            if (i > maxDistance) return false;
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return true;
    }
}