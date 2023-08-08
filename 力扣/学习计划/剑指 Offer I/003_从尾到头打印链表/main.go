package main

type ListNode struct {
	Val  int
	Next *ListNode
}

// 空间较大的循环
func reversePrint(head *ListNode) []int {
	vals := make([]int, 0)
	for head != nil {
		vals = append(vals, head.Val)
		head = head.Next
	}
	res := make([]int, 0)
	for i := len(vals) - 1; i >= 0; i-- {
		res = append(res, vals[i])
	}
	return res
}

// 空间较小的循环
func reversePrint2(head *ListNode) []int {
	cn := 0
	for p := head; p != nil; p = p.Next {
		cn++
	}
	node := make([]int, cn)
	for head != nil {
		node[cn-1] = head.Val
		head = head.Next
		cn--
	}
	return node
}

// 题解：递归
func reversePrint3(head *ListNode) []int {
	if head == nil {
		return nil
	}
	return append(reversePrint(head.Next), head.Val)
}
