import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 哈希表
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        Map<Integer, ListNode> tmp = new HashMap<>();
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            tmp.put(i++, cur);
            cur = cur.next;
        }
        return tmp.get(i - k);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}