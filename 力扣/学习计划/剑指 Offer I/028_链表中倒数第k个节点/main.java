/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
class Solution {
    /**
     * 暴力循环两次
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        cur = head;
        while (n > k) {
            cur = cur.next;
            n--;
        }
        return cur;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}