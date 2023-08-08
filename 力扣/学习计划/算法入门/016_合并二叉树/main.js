/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 合并二叉树
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {TreeNode}
 * 递归
 */
var mergeTrees = function (root1, root2) {
    if (!root1 && !root2) return null
    if (root1 && !root2) return root1
    if (!root1 && root2) return root2
    let root = new TreeNode(root1.val + root2.val)
    root.left = mergeTrees(root1.left, root2.left)
    root.right = mergeTrees(root1.right, root2.right)
    return root
}