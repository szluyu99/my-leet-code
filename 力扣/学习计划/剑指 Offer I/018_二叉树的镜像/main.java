import java.util.Stack;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/
 */
class Solution {
	/**
	 * 递归 DFB
	 */
    public TreeNode mirrorTree(TreeNode root) {
		if (root == null) return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode leftNode = mirrorTree(root.left);
        TreeNode rightNode = mirrorTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
		return root;
    }
	/**
	 * 辅助栈
	 */
	public TreeNode mirrorTree1(TreeNode root) {
		if (root == null) return null;
		Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node.left != null)
				stack.add(node.left);
			if (node.right != null)
				stack.add(node.right);
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}
		return root;	
	}
}
