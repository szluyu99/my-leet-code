import java.util.List;

class BSTIterator {
    List<Integer> list;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        dfs(root);
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public int next() {
        return list.remove(0);
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}