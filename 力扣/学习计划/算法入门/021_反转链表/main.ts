/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转链表
 */

/**
 * 递归
 */
//  1 -> 2 <- 3 <- 4 <- 5
//  |                   |
// res                 node
let reverseList = function (head: ListNode | null): ListNode | null {
    if (!head || !head.next) return head
    let node = reverseList(head.next)
    head.next.next = head
    head.next = null
    return node
}

/**
 * 迭代, map
 */
reverseList = function (head: ListNode | null): ListNode | null {
    let map = new Map(), idx = 0
    while (head) {
        map.set(idx++, head.val)
        head = head.next
    }
    let newHead = new ListNode(0), res = newHead
    while (idx > 0) {
        newHead.next = new ListNode(map.get(--idx))
        newHead = newHead.next
    }
    return res.next
}

/**
 * 迭代, 交换指针
 * 1 -> 2 -> 3 -> 4 -> null
 * null <- 1 <- 2 <- 3 <- 4
 */
reverseList = function (head: ListNode | null): ListNode | null {
    // prev 前节点, cur 当前节点
    let prev = null, cur = head
    // 每次循环, 将 当前节点 指向 前节点, 然后 当前节点 和 前节点 后移
    while (cur) {
        let tmpNode = cur.next // 保存 当前节点 的下一节点
        cur.next = prev // 当前节点 指向 前节点
        prev = cur // 前节点后移
        cur = tmpNode // 当前节点后移
    }
    return prev
}