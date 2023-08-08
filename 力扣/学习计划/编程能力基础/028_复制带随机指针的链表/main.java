/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * 复制带随机指针的链表
 */
class Solution {
    public Node copyRandomList(Node head) {
        // 使用 map 存储 旧结点 和 新结点 的映射
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
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