import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

class Solution {
    /**
     * MJ：BFS1 
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> resList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>(){{ offer(root); }};
        List<Integer> tmpList = new ArrayList<>();
        int levelSize = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tmpList.add(node.val);
            levelSize--;
            
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            
            if (levelSize == 0) {
                resList.add(tmpList);
                levelSize = queue.size();
                tmpList = new ArrayList<>();
            }
        }
        return resList;
    }
    /**
     * 题解：BFS2
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>() {{ offer(root); }};
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (i == 0) 
                    resList.add(tmpList);
            }
        }
        return resList;
    }
}
