class Node {
    val: number
    children: Node[]
    constructor(val?: number) {
        this.val = (val === undefined ? 0 : val)
        this.children = []
    }
}

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ 
 * N 叉树的层序遍历
 */
/**
 * BFS
 */
let levelOrder = function (root: Node | null): number[][] {
    if (!root) return []
    let queue = [root], res = []
    while (queue.length) {
        let temp = []
        for (let i = queue.length - 1; i >= 0; i--) {
            let node = queue.pop()
            temp.unshift(node.val)
            queue.unshift(...node.children)
        }
        res.push(temp)
    }
    return res
};