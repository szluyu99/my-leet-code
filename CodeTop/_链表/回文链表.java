package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/palindrome-linked-list/
// 1. 寻找链表中间节点
// 2. 反转后半部分
// 3. 检查是否是回文
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;

        ListNode right = reverse(slow);
        while (right != null) {
            if (head.val != right.val) return false;
            head = head.next;
            right = right.next;
        }
        
        return true;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null; 
        return node;
    }
}