import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 */
class Solution {
    /**
     * 双栈
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> resList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);

        boolean flag = true;
        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            List<Integer> tmpList = new ArrayList<>();
            if (flag) {
                for (int i = stack1.size(); i > 0; i--) {
                    TreeNode node = stack1.pop();
                    tmpList.add(node.val);
                    if (node.left != null)
                        stack2.add(node.left);
                    if (node.right != null)
                        stack2.add(node.right);
                }
            } else {
                for (int i = stack2.size(); i > 0; i--) {
                    TreeNode node = stack2.pop();
                    tmpList.add(node.val);
                    if (node.right != null)
                        stack1.add(node.right);
                    if (node.left != null)
                        stack1.add(node.left);
                }

            }
            resList.add(tmpList);
            flag = !flag;
        }
        return resList;
    }
}
