/**
 * DFS
 */
let maxLevel = 0
var maxDepth = function (root) {
    dfs(root, 1)
    return maxLevel
};

const dfs = (root, level) => {
    if (!root) return
    (level > maxLevel) && (maxLevel = level)
    dfs(root.left, level + 1)
    dfs(root.right, level + 1)
}