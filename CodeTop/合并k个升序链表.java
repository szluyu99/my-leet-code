package CodeTop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import common.ListNode;

// https://leetcode.cn/problems/merge-k-sorted-lists/submissions/
// 模拟
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode dummy = new ListNode(0);
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            } 
        }

        Collections.sort(list, (a, b) -> a.val - b.val);

        ListNode cur = dummy;
        for (ListNode node : list) {
            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }
}

// 优先级队列
class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) pq.add(node.next);
        }
        return dummy.next;
    }
}

// 分治
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = (l + r) >> 1;
        ListNode l1 = merge(lists, l, mid);
        ListNode l2 = merge(lists, mid + 1, r);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}