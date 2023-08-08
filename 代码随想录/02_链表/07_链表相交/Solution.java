import java.util.HashSet;
import java.util.Set;

import common.ListNode;

// https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
// set
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        p = headB;
        while (p != null) {
            if (set.contains(p)) return p;
            p = p.next;
        }
        return null;
    }
}

// 双指针
class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lenA = 0, lenB = 0;
        // 求链表 A 的长度
        while (curA != null) { lenA++; curA = curA.next; }
        // 求链表 B 的长度
        while (curB != null) { lenB++; curB = curB.next; }
        curA = headA;
        curB = headB;
        // 链表 A 更长则让 A 多走, B 更长则让 B 多走，保证 A B 从同一位置开始比较
        if (lenA > lenB) for (int i = 0; i < lenA - lenB; i++) curA = curA.next;
        else for (int i = 0; i < lenB - lenA; i++) curB = curB.next;
        // 逐个比较 A 和 B 
        while (curA != null) {
            if (curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}

// 巧妙
class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            h1 = (h1 == null) ? headB : h1.next;
            h2 = (h2 == null) ? headA : h2.next;
        }
        return h1;
    }
}