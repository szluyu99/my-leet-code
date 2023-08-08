class Solution {
    /**
     * 双指针 + 交叉
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA, B = headB;
        while (A != B) {
            A = (A != null) ? A.next : headB;
            B = (B != null) ? B.next : headA;
        }
        return A;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}