import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    /**
     * 双端队列
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> resList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            // 打印奇数层
            for (int i = deque.size(); i > 0; i--) {
                // 左 -> 右
                TreeNode node = deque.removeFirst();
                tmpList.add(node.val);
                // 先左后右加入下层节点
                if (node.left != null)
                    deque.addLast(node.left);
                if (node.right != null)
                    deque.addLast(node.right);
            }
            resList.add(tmpList);

            if (deque.isEmpty())
                break;

            // 打印偶数层
            tmpList = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 右 -> 左
                TreeNode node = deque.removeLast();
                tmpList.add(node.val);
                // 先右后左加入下层节点
                if (node.right != null)
                    deque.addFirst(node.right);
                if (node.left != null)
                    deque.addFirst(node.left);
            }
            resList.add(tmpList);
        }

        return resList;
    }
}