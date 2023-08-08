package main

func levelOrder(root *TreeNode) [][]int {
	res := make([][]int, 0)
	var helper func(node *TreeNode, level int)
	helper = func(node *TreeNode, level int) {
		if node == nil {
			return
		}
		if len(res) <= level {
			res = append(res, []int{})
		}

	}

	helper(root, 0)
	return res
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
