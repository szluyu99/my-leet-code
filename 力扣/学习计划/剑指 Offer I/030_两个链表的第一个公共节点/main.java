import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
class Solution {
    /**
     * 哈希
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = headA;
        while (cur != null) {
            map.put(cur.val, cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (map.get(cur.val) == cur)
                return cur;
            cur = cur.next;
        }
        return null;
    }
    /**
     * set
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (set.contains(cur))
                return cur;
            cur = cur.next;
        }
        return null;
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