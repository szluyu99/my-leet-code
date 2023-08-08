import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */


class Solution {
    /**
     * 暴力
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node newNode = new Node(head.val);
        // 保存两个链表的首指针
        Node pHead = head, pNew = newNode; 
        while (pHead != null) {
            pNew.next = pHead.next == null ? null : new Node(pHead.next.val);
            if (pHead.random == null)
                pNew.random = null;
            pNew = pNew.next;
            pHead = pHead.next; 
        }
        // 恢复指针状态
        pHead = head;
        pNew = newNode; 
        
        while (pHead != null) {
            // 寻找random节点
            Node tmpNode = head, ptmpNode = newNode;
            while (pHead.random != tmpNode) {
                tmpNode = tmpNode.next;
                ptmpNode = ptmpNode.next; 
            }
            pNew.random = ptmpNode;

            pNew = pNew.next;
            pHead = pHead.next;
        }
        return newNode;
    }
    /**
     * 哈希
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 复制各节点，并建立 "原节点 -> 新节点" 的映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 构建新的next和random指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    /**
     * 拼接 + 拆分
     */
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next; 
            // cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        // 3，拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;             
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}