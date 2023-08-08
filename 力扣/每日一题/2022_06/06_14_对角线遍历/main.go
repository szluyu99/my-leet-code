package main

// https://leetcode.cn/problems/diagonal-traverse/
// 498. 对角线遍历

func findDiagonalOrder(mat [][]int) (res []int) {
	m, n := len(mat), len(mat[0])
	i, j := 0, 0  // 横纵坐标
	right := true // 是否往右上角遍历
	// 直到遍历到右下角才停止
	for i != m && j != n {
		res = append(res, mat[i][j])
		if right {
			i, j = i-1, j+1 // 往右上角走
			if j >= n {     // 超出右上角边界
				right = false
				i, j = i+2, j-1
			} else if i < 0 { // 超出上方边界
				right = false
				i += 1
			}
		} else {
			i, j = i+1, j-1 // 往左下角走
			if i >= m {     // 超出左下角边界
				right = true
				i, j = i-1, j+2
			} else if j < 0 { // 超出左方边界
				right = true
				j += 1
			}
		}
	}
	return res
}
