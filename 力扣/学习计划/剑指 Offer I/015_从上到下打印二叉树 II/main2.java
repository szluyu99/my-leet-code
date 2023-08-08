import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 递归
     */
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return resList;
    }

    // 本质上是先序遍历
    public void helper(TreeNode node, int level) {
        if (node == null) return;
        if (resList.size() <= level)
            resList.add(new ArrayList<>());
        resList.get(level).add(node.val);
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}