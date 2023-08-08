package main

import "math"

// https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
// 515. 在每个树行中找最大值

func largestValues(root *TreeNode) (res []int) {
	if root == nil {
		return []int{}
	}

	queue := []*TreeNode{root}
	for len(queue) > 0 {
		size := len(queue)
		max := math.MinInt
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			max = getMax(max, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		res = append(res, max)
	}

	return res
}

func getMax(a, b int) int {
	if a > b {
		return a
	}
	return b
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
