package 比赛.LCCUP22;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// TODO
class Solution {
    // dp[0] 表示只切换当前节点
    // dp[1] 表示切换以当前节点为根 的子树中，所有节点上的灯的状态，
    // dp[2] 切换 当前节点及其左右子节点（若存在的话） 上的灯的状态
    public int closeLampInTree(TreeNode root) {
        int dp = dfs(root);
        return 0;
    }

    // 每次的选择与父节点的状态有关
    int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);

        int cnt = 0;
        // 操作 1
        
        // 操作 2

        // 操作 3

        return cnt;
    }
}