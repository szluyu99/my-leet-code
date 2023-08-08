/**
 * 栈优化
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> s1 = new LinkedList<>(), s2 = new LinkedList<>();
        while (l1 != null) {
            s1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.addFirst(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode lastNode = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int n1 = s1.isEmpty() ? 0 : s1.removeFirst();
            int n2 = s2.isEmpty() ? 0 : s2.removeFirst();
            int sum = n1 + n2 + +carry;
            carry = sum / 10;
            ListNode curNode = new ListNode(sum % 10);
            curNode.next = lastNode;
            lastNode = curNode;
        }
        return lastNode;
    }
}
