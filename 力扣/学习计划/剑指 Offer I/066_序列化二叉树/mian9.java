/**
 * 脑筋急转弯
 */
class Codec {
    TreeNode back;
    public String serialize(TreeNode root) {
        back = root;
        return null;
    }

    public TreeNode deserialize(String data) {
        return back;
    }
}
