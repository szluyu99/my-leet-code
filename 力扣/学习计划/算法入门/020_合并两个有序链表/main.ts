/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个有序链表
 */

/*
 * 递归（需要创建新结点）
 * 旧写法
 */
let mergeTwoLists = function (list1: ListNode | null, list2: ListNode | null): ListNode | null {
    if (!list1 && !list2) return null
    if (list1 && !list2) return list1
    if (!list1 && list2) return list2
    // list1 && list2 的情况
    return list1.val <= list2.val
        ? new ListNode(list1.val, mergeTwoLists(list1.next, list2))
        : new ListNode(list2.val, mergeTwoLists(list1, list2.next))
};

/**
 * 递归（创建新结点）
 * 新写法（更简洁）
 */
mergeTwoLists = function (list1: ListNode | null, list2: ListNode | null): ListNode | null {
    if (!list2) return list1
    if (!list1) return list2
    return list1.val <= list2.val
        ? new ListNode(list1.val, mergeTwoLists(list1.next, list2))
        : new ListNode(list2.val, mergeTwoLists(list1, list2.next))
};

/**
 * 递归（不创建新结点）
 */
mergeTwoLists = function (list1: ListNode | null, list2: ListNode | null): ListNode | null {
    if (!list1) return list2
    if (!list2) return list1
    if (list1.val < list2.val) {
        list1.next = mergeTwoLists(list1.next, list2)
        return list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        return list2
    }
}

/**
 * 迭代（不创建新结点）
 */
mergeTwoLists = function (list1: ListNode | null, list2: ListNode | null): ListNode | null {
    let res = new ListNode(0), cur = res

    while (list1 && list2) {
        if (list1.val <= list2.val) {
            cur.next = list1
            list1 = list1.next
        } else {
            cur.next = list2
            list2 = list2.next
        }
        cur = cur.next
    }
    cur.next = list1 ?? list2;
    return res.next
}

class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}