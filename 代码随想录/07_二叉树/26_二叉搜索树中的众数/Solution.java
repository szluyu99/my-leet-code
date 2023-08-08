import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

// https://leetcode.cn/problems/find-mode-in-binary-search-tree/
// 常规 DFS
class Solution {
    final int N = 100010;
    int[] map = new int[N + N]; // 某个数字的出现次数
    int maxCount = 0; // 某个数字出现最多的次数
    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++)
            if (map[i] == maxCount)  list.add(i - N);
        int[] res = new int[list.size()];
        int k = 0;
        for (Integer i : list) res[k++] = i;
        return res;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        map[root.val + N]++; // 映射为正值
        maxCount = Math.max(maxCount, map[root.val + N]);
        dfs(root.right);
    }
}

// 利用二叉搜索树特性，DFS 时处理
class Solution1 {
    List<Integer> list = new ArrayList<>();
    int preVal = 0; // 上一个值
    int curTimes = 0; // 当前值的出现次数
    int  maxTimes = 0; // 最大的出现次数

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        int k = 0;
        for (Integer i : list) res[k++] = i;
        return res;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        // 判断 当前值 与 上一个值 的关系
        if (preVal == node.val) curTimes++;
        else {
            preVal = node.val;
            curTimes = 1;
        }
        // 判断 当前数量 和 最大数量 的关系
        if (curTimes == maxTimes) list.add(node.val);
        else if (curTimes > maxTimes) {
            list.clear();
            list.add(node.val);
            maxTimes = curTimes;
        }
        dfs(node.right);
    }
}