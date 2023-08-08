import java.util.LinkedList;

import common.TreeNode;

/**
 * DFS 先序遍历 序列化
 */
class Codec {
    /**
     * 最近子问题
     * 当前树的序列化 = join(root.val, 左子树的序列化, 右子树的序列化)
     */
    public String serialize(TreeNode root) {
        if (root == null) return "x"; // 空节点编码为 x
        String left = serialize(root.left);
        String right = serialize(root.right);
        return String.join(",", String.valueOf(root.val), left, right);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        for (String s : data.split(","))
            queue.add(s);
        return buildTree(queue);       
    }

    /**
     * 最近子问题
     * 构建当前树 = (root.val, 构建左子树, 构建右子树)
     */
    private TreeNode buildTree(LinkedList<String> queue) {
        String root = queue.removeFirst();
        if ("x".equals(root)) return null;
        return new TreeNode(Integer.parseInt(root), buildTree(queue), buildTree(queue));
    }

}
