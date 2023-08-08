package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	arr := make([]int, 0)
	dfs(root, arr)
	return arr
}

func dfs(root *TreeNode, arr []int) {
	if root == nil {
		return
	}
	dfs(root.Left, arr)
	arr = append(arr, root.Val)
	dfs(root.Right, arr)
}
