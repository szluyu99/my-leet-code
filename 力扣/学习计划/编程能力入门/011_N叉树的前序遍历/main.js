/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/
 * N 叉树的前序遍历
 * @param {Node|null} root
 * @return {number[]}
 * 递归
 */
var preorder = function (root) {
    if (root == null) return []
    let res = [root.val]
    for (let n of root.children)
        res.push(...preorder(n))
    return res
};
