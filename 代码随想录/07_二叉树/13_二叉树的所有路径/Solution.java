import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

// https://leetcode.cn/problems/binary-tree-paths/
// DFS + StringBuilder
class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(new StringBuilder(), root); 
        return res;
    }

    void dfs(StringBuilder path, TreeNode node) {
        if (node == null) return;
        path.append(node.val); 
        if (node.left == null && node.right == null) {
            res.add(path.toString());
            return;
        }
        dfs(new StringBuilder(path).append("->"), node.left);
        dfs(new StringBuilder(path).append("->"), node.right);
    }
}
