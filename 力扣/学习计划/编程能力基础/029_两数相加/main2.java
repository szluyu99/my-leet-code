class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        return root.next;
    }
}