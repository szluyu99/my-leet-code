/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 876. 链表的中间结点
 * @param {ListNode} head
 * @return {ListNode}
 * map
 */
var middleNode = function (head) {
    let map = new Map(), idx = 0
    while (head) {
        map.set(idx++, head)
        head = head.next
    }
    return map.get(Math.ceil(--idx / 2))
};

/**
 * 快慢指针
 */
var middleNode = function (head) {
    let slow = head, fast = head
    while (fast.next) {
        slow = slow.next
        fast = fast.next
        fast.next && (fast = fast.next)
    }
    return slow
};

/**
 * 快慢指针
 */
var middleNode = function (head) {
    let slow = head, fast = head
    while (fast && fast.next) {
        slow = slow.next
        fast = fast.next.next
    }
    return slow
};