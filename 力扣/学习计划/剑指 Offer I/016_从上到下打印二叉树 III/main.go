package main

func levelOrder(root *TreeNode) [][]int {
	var res = make([][]int, 0)
	if root == nil {
		return res
	}

	queue := []*TreeNode{root}

	// 奇偶顺序控制
	flag := false
	for len(queue) > 0 {
		length := len(queue)
		tmp := make([]int, length)

		for i := 0; i < length; i++ {
			node := queue[0]
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
			if flag {
				tmp[length-i-1] = node.Val
			} else {
				tmp[i] = node.Val
			}
		}
		res = append(res, tmp)
		flag = !flag
	}
	return res
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
