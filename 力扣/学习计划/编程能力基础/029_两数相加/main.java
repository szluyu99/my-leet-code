/**
 * https://leetcode-cn.com/problems/add-two-numbers/submissions/
 * 2. 两数相加
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 短的数字后面用 0 补上
        ListNode t1 = l1, t2 = l2;
        while (t1 != null || t2 != null) {
            if (t1.next == null && t2.next == null) break;
            if (t1.next == null) t1.next = new ListNode(0);
            else if (t2.next == null)  t2.next = new ListNode(0);
            t1 = t1.next;
            t2 = t2.next;
        }

        int carry = 0;
        ListNode dump = new ListNode(0), res = dump;
        while (l1 != null || l2 != null || carry > 0) {
            int n1 = (l1 == null) ? 0 : l1.val;
            int n2 = (l2 == null) ? 0 : l2.val;
            int sumVal = n1 + n2 + carry; // 计算数字 + 进位和
            carry = sumVal / 10; // 计算下一个进位

            dump.next = new ListNode(sumVal % 10);
            dump = dump.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return res.next;
    }
}