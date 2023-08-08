import common.TreeNode;

// https://leetcode.cn/problems/house-robber-iii/
class Solution {
    public int rob(TreeNode root) {
        // dp[0] 不偷当前节点的方案的最大值
        // dp[i] 偷当前节点的方案的最大值
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // 不偷当前点(左右孩子可以偷): max(左孩子不偷, 左孩子偷) + max(右孩子不偷, 右孩子偷)
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前点(左右孩子不能偷): 左孩子不偷 + 右孩子不偷 + 当前节点的值
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}