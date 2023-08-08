package main

// https://leetcode.cn/problems/find-bottom-left-tree-value/
// 513. 找树左下角的值
func findBottomLeftValue(root *TreeNode) int {
	que := []*TreeNode{root}

	for len(que) > 0 {
		root = que[0] // 取出队首元素
		que = que[1:] // 弹出队首元素

		if root.Right != nil {
			que = append(que, root.Right)
		}

		if root.Left != nil {
			que = append(que, root.Left)
		}
	}

	return root.Val
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
