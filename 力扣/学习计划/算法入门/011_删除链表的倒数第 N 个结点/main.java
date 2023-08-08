class Solution {
    int cur = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        head.next = removeNthFromEnd(head.next, n);
        cur++;
        if (cur == n)
            return head.next;
        return head;
    }
}

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}