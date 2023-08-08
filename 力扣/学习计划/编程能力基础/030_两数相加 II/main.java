/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * 445. 两数相加 II
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverList(l1);
        l2 = reverList(l2);

        ListNode root = new ListNode(0), cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int n1 = (l1 == null) ? 0 : l1.val;
            int n2 = (l2 == null) ? 0 : l2.val;
            int sumVal = n1 + n2 + carry; // 计算数字 + 进位和
            carry = sumVal / 10; // 计算下一个进位

            cursor.next = new ListNode(sumVal % 10);
            cursor = cursor.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return reverList(root.next);
    }

    ListNode reverList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}