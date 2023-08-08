import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

class Solution {
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Object> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            Object o = st.pop();
            if (o instanceof TreeNode) {
                TreeNode node = (TreeNode) o;
                if (node.right != null) st.push(node.right);
                st.push(node.val);
                if (node.left != null) st.push(node.left);
            } else {
                res.add((Integer) o);
            }
        }
        return res;
    }

    // 先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Object> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            Object o = st.pop();
            if (o instanceof TreeNode) {
                TreeNode node = (TreeNode) o;
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node.val);
            } else {
                res.add((Integer) o);
            }
        }
        return res;
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode cur = root;
        Stack<Object> st = new Stack<>();
        st.push(cur);
        while (!st.isEmpty()) {
            Object o = st.pop();
            if (o instanceof TreeNode) {
                TreeNode node = (TreeNode) o;
                st.push(node.val);
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
            } else {
                res.add((Integer)o);
            }
        }
        return res;
    }
}
