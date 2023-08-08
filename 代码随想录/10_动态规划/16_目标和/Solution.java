import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/target-sum/
// 二维 DP
class Solution {
    // sumA - 正数和, sumB - 负数和, sum - nums 的和
    // sumA + sumB = target
    // sumA - sumB = sum
    // sumA = (target + sum) / 2
    // 同时可以发现 target + sum 必须是偶数, 否则无解
    // 转化成 01背包, dp[i][j] 从前 i 个数字中选出若干个, 使得被选出的数字其和为 j 的方案数目
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((target + sum) % 2 == 1) return 0; // 奇数, 无解
        // 若 target > sum, 无法凑够; target 太小导致 target + sum < 0，也凑不够
        if (sum < Math.abs(target)) return 0;

        // dp[i][j] 从前 i 个数字中选出若干个, 使得被选出的数字其和为 j 的方案数目
        // dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]]
        int c = (sum + target) >> 1;
        int[][] dp = new int[nums.length + 1][c + 1];
        dp[0][0] = 1; // dp[i][0] 除了 dp[0][0] = 1, 有多个数字的情况下, 和为 0 的情况可能有多个
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= c; j++) { // j 从 0开始, 因为数字和可以为 0 (这点和背包有区别)
                // 容量有限, 无法更新
                if (j < nums[i - 1]) dp[i][j] = dp[i - 1][j];
                // 可以选择第 i 个数字 nums[i - 1], 也可以不选, s两者和
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][c];
    }
}

// 一维 DP
class Solution1 {
    // sumA - 正数和, sumB - 负数和, sum - nums 的和
    // sumA + sumB = target
    // sumA - sumB = sum
    // sumA = (target + sum) / 2
    // 同时可以发现 target + sum 必须是偶数, 否则无解
    // 转化成 01背包, dp[i][j] 从前 i 个数字中选出若干个, 使得被选出的数字其和为 j 的方案数目
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((target + sum) % 2 == 1) return 0; // 奇数, 无解
        // 若 target > sum, 无法凑够; target 太小导致 target + sum < 0，也凑不够
        if (sum < Math.abs(target)) return 0;

        // dp[j] 选出数字和为 j 的方案数目 dp[j] += dp[j - nums[i]]
        int c = (sum + target) >> 1;
        int[] dp = new int[c + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = c; j >= 0; j--) { // j 从 0开始, 因为数字和可以为 0 (这点和背包有区别)
                // 容量有限, 无法更新
                if (j < nums[i - 1]) continue;
                // 可以选择第 i 个数字 nums[i - 1], 也可以不选, s两者和
                dp[j] += dp[j - nums[i -    1]];
            }
        }
        return dp[c];
    }
}

// 回溯
class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    int dfs(int[] nums, int target, int idx) {
        if (idx == nums.length) {
            if (target == 0) return 1;
            return 0;
        }
        return dfs(nums, target - nums[idx], idx + 1) + dfs(nums, target + nums[idx], idx + 1);
    }
}

// 记忆化搜索
class Solution3 {
    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    int dfs(int[] nums, int target, int sum,  int idx) {
        if (nums.length == idx) {
            if (target == sum) return 1;
            else return 0;
        }

        String key = sum + "&" + idx;
        if (map.containsKey(key)) return map.get(key);
        int val = dfs(nums, target, sum + nums[idx], idx + 1) + dfs(nums, target, sum - nums[idx], idx + 1);
        map.put(key, val);
        return val;
    }
}