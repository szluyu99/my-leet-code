package CodeTop.N叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.Node;

// https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
// 递归
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    void dfs(Node node) {
        if (node == null) return;
        res.add(node.val);
        for (Node n : node.children) dfs(n);
        return;
    }
}

// 统一迭代
class Solution1 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Object> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Object o = st.pop();
            if (o instanceof Node) {
                Node node = (Node) o;
                List<Node> nodes = node.children;
                for (int i = nodes.size() - 1; i >= 0; i--) 
                    st.push(nodes.get(i));
                st.push(node.val);
            } else {
                res.add((Integer) o);
            }
        }
        return res;
    }
}

// 迭代
class Solution3 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node node = st.pop();
            res.add(node.val);
            List<Node> nodes = node.children;
            for (int i = nodes.size() - 1; i >= 0; i--) 
                st.push(nodes.get(i));
        }
        return res;
    }
}
