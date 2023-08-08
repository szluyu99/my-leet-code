import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
class Solution {
    /**
     * 辅助栈 + 迭代
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode node = new ListNode(stack.pop());
        ListNode res = node;
        while (!stack.isEmpty()) {
            node.next = new ListNode(stack.pop());
            node = node.next;
        }
        return res;
    }
    /**
     * 题解：双指针法
     */
    public ListNode reverseList2(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 题解：递归
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    /**
     * 题解：递归2
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        return recur(head, null);
    }
    public ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode node = recur(cur.next, cur);
        cur.next = pre;
        return node;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        ListNode res = new Solution().reverseList(node);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val); 
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
