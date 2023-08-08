import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 回溯 + 剪枝
 */
class Solution {
    // 存储找到 p 为止走过的路径
    List<TreeNode> pList = new ArrayList<>();
    // 存储找到 q 为止走过的路径
    List<TreeNode> qList = new ArrayList<>();
    // 用来判断 pList, qList 是否继续存储路径
    boolean pFlag = false, qFlag = false; 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        // pList 从后往前找，直到找到 qList 中也包含的节点，即为 公共祖先
        for (int i = pList.size() - 1; i >= 0; i--) 
            if (qList.contains(pList.get(i))) 
                return pList.get(i);
        return null;
    }
    /**
     * 深度优先搜索 root, 同时将走过的路径分别加入 pList、qList
     * 直到 p、q 节点都已经遍历过
     */
    void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (!pFlag) pList.add(root);
        if (!qFlag) qList.add(root);
        if (root.val == p.val) pFlag = true;
        if (root.val == q.val) qFlag = true;
        if (pFlag && qFlag) return; // 剪枝
        dfs(root.left, p, q);
        dfs(root.right, p, q);
        // 回溯
        if (!pFlag) pList.remove(pList.size() - 1);
        if (!qFlag) qList.remove(qList.size() - 1);
    }
}