package main

func mirrorTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	leftNode, rightNode := mirrorTree(root.Left), mirrorTree(root.Right)
	root.Left, root.Right = rightNode, leftNode
	return root
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
