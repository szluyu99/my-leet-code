import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/submissions/
 * BFS 层次遍历 序列化
 */
class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        List<Integer> list = new LinkedList<>() {{ add(root.val); }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null)  {
                queue.add(node.left);
                list.add(node.left.val);
            } else list.add(null);
            if (node.right != null) {
                queue.add(node.right);
                list.add(node.right.val);
            } else list.add(null);
        }
        return list.toString().replace(" ", ""); 
    }

    public TreeNode deserialize(String data) {
        if (data == null) return null;

        String[] vals = data.substring(1, data.length() - 1).split(",");
        // [1,2,3,null,null,4,5]

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        
        return root;
    }
    
}