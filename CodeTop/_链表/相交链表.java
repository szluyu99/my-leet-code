package CodeTop._链表;

import java.util.HashSet;
import java.util.Set;

import common.ListNode;

// https://leetcode.cn/problems/intersection-of-two-linked-lists/
// set
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }
}


// 走对方的路
class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;

        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;

            if (h1 == null && h2 == null) break;
            if (h1 == null) h1 = headB;
            if (h2 == null) h2 = headA;
        }

        return h1;
    }
}