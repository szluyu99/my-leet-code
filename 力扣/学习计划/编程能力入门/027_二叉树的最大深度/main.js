function TreeNode(val, left, right) {
    this.val = (val === undefined ? 0 : val)
    this.left = (left === undefined ? null : left)
    this.right = (right === undefined ? null : right)
}

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 104. 二叉树的最大深度s
 * @param {TreeNode} root
 * @return {number}
 * 递归
 */
var maxDepth = function (root) {
    if (!root) return 0
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
};

/**
 * BFS
 */
var maxDepth = function (root) {
    if (!root) return 0
    let level = 0, queue = [root]
    while (queue.length) {
        level++
        for (let i = queue.length - 1; i >= 0; i--) {
            let node = queue.pop()
            node.left && queue.unshift(node.left)
            node.right && queue.unshift(node.right)
        }
    }
    return level
};