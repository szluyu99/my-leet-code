package main

func levelOrder(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	var res = make([]int, 0)

	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	for len(queue) != 0 {
		node := queue[0]
		queue = queue[1:] // 模拟队列出队

		res = append(res, node.Val)
		if node.Left != nil {
			queue = append(queue, node.Left)
		}
		if node.Right != nil {
			queue = append(queue, node.Right)
		}
	}
	return res
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
