package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/sum-root-to-leaf-numbers/submissions/

// 递归写法 1
class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    void dfs(TreeNode root, int num) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += num * 10 + root.val;
            return;
        }
        num = num * 10 + root.val;
        dfs(root.left, num);
        dfs(root.right, num);
    }
}

// 递归写法 2
class Solution1 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        num = num * 10 + root.val;
        return dfs(root.left, num) + dfs(root.right, num);
    }
}