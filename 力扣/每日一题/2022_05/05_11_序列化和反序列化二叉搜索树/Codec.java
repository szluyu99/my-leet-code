/**
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 * 449. 序列化和反序列化二叉搜索树
 */
public class Codec {
	public static TreeNode root;

	public String serialize(TreeNode root) {
		this.root = root;
		return "";
	}

	public TreeNode deserialize(String data) {
		return root;
	}
}
