/**
 * // Definition for a Node.
 * function Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 填充每个节点的下一个右侧节点指针
 * @param {Node} root
 * @return {Node}
 */
var connect = function (root) {
    if (!root) return null
    if (root.left) {
        // 处理下一层
        root.left.next = root.right
        // 循环处理后面的层
        let tmp1 = root.left, tmp2 = root.right
        while (tmp1.right) {
            tmp1.right.next = tmp2.left
            tmp1 = tmp1.right
            tmp2 = tmp2.left
        }
    }
    connect(root.left)
    connect(root.right)
    return root
}

var connect = function (root) {
    if (!root) return null
    if (root.left) {
        root.left.next = root.right
        if (root.next)
            root.right.next = root.next.left
    }
    connect(root.left)
    connect(root.right)
    return root
}