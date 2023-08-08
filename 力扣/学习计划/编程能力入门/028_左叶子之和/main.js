function TreeNode(val, left, right) {
    this.val = (val === undefined ? 0 : val)
    this.left = (left === undefined ? null : left)
    this.right = (right === undefined ? null : right)
}

/**
 * @param {TreeNode} root
 * @return {number}
 * DFS
 */
var sumOfLeftLeaves = function (root) {
    let sum = 0
    return dfs(root, false, sum)
};

const dfs = (root, isLeft, sum) => {
    if (!root) return 0
    // 是左节点, 且是叶子节点
    if (isLeft && !root.left && !root.right)
        sum += root.val
    return sum + dfs(root.left, true, sum) + dfs(root.right, false, sum)
}

/**
 * 递归
 */
var sumOfLeftLeaves = function (root) {
    if (!root) return 0
    let sum = 0
    // 判断节点是否是左叶子节点, 是则累加其和
    if (root.left && !root.left.left && !root.left.right)
        sum += root.left.val
    return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + sum
};