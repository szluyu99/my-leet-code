import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return null;
        
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>() {{ offer(root); }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resList.add(node.val);

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return resList.stream().mapToInt(e -> e.intValue()).toArray();
    }
}