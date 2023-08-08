// https://leetcode.cn/problems/wiggle-subsequence/
// 模拟
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        int res = 1;
        Boolean flag = null; // 控制方向
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue; // 0
            if (nums[i] - nums[i - 1] > 0) { // 正值
                if (flag != null && flag) continue; 
                flag = true;
            } else { // 负值
                if (flag != null && !flag) continue; 
                flag = false;
            }
            res++;
        }
        return res;
    }
}

// DP 一维
class Solution1 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        
        int[] up = new int[n]; // 以 i 结尾的升序的最长摆动序列的长度
        int[] down = new int[n]; // 以 i 结尾的降序的最长摆动序列的长度
        up[0] = down[0] = 1;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) { // 当前是升序
                up[i] = down[i - 1] + 1; // 由上一个降序递推
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) { // 当前降序
                up[i] = up[i - 1]; 
                down[i] = up[i - 1] + 1; // 由上一个升序递推
            } else { // 不变
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}

// DP - 二维
class Solution2 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        // dp[i][0] 表示 nums[0] 到 nums[i] 的最长摆动序列长度, 且 nums[i] < nums[i - 1], 往下
        // dp[i][1] 表示 nums[0] 到 nums[i] 的最长摆动序列长度, 且 nums[i] > nums[i - 1], 往上
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] > nums[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}

// 判断连续上升或者下降的波段个数
// 动态规划 - 优化
class Solution3 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;

        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) up = down + 1;
            if (nums[i] < nums[i - 1]) down = up + 1;
        }
        return Math.max(up, down);
    }
}