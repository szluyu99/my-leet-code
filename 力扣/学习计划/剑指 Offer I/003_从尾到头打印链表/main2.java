import java.util.ArrayList;

/**
 * 题解：递归
 */
class Solution {
    ArrayList<Integer> tmp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}