/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 110. 平衡二叉树
 */

/**
 * 从顶至底（暴力）
 */
let isBalanced = function (root: TreeNode | null): boolean {
    if (!root) return true
    if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
        return false
    return isBalanced(root.left) && isBalanced(root.right)
}
// 获取二叉树节点的高度
const getHeight = (root: TreeNode | null) => {
    if (!root) return 0
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1
}

/**
 * 从底至顶
 */
isBalanced = function (root: TreeNode | null): boolean {
    return recur(root) != -1
}

const recur = function (root: TreeNode | null): number {
    if (!root) return 0
    let left = recur(root.left)
    if (left == -1) return -1
    let right = recur(root.right)
    if (right == -1) return -1
    return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1
}

class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}
