/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
class Solution {
    /**
     * 耗费空间大的循环
     */
    public int[] reversePrint(ListNode head) {
        int[] vals = new int[10001];
        int len = 0;
        while (head != null) {
            vals[len++] = head.val;
            head = head.next;
        }
        int[] res = new int[len];
        int i = 0;
        for (int j = len; j >= 0; j--) {
            res[i++] = vals[j];
        }
        return res;
    }

    /**
     * 耗费空间较小的循环
     */
    public int[] reversePrint2(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] nums = new int[len];
        node = head;
        for (int i = len - 1; i >=0; i--) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }

    /**
     * 题解：辅助栈
     */
    public int[] reversePrint3(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) 
            res[i] = stack.pop();
        return res;
    }    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}