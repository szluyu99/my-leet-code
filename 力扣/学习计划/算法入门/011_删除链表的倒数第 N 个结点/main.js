/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第 N 个结点
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
    if (!head.next) return null

    let slow = head, fast = head
    while (n--)
        fast = fast.next
    if (!fast) return head.next
    while (fast && fast.next) {
        slow = slow.next
        fast = fast.next
    }
    slow.next = slow.next.next
    return head
};



