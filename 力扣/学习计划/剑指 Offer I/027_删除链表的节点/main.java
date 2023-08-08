/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/mian-shi-ti-18-shan-chu-lian-biao-de-jie-dian-sh-2/
 */
class Solution {
    /**
     * 迭代
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        // cur 进行遍历, pre 保存遍历的前一位置
        ListNode cur = head, pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur; // 保存遍历的前一位置
            cur = cur.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}