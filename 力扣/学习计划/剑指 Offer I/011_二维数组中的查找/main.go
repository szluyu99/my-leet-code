package main

import (
	"fmt"
)

// 迭代
func findNumberIn2DArray(matrix [][]int, target int) bool {
	for _, item := range matrix {
		for _, v := range item {
			if target == v {
				return true
			}
		}
	}
	return false
}

// 斜角线排除（负面优化，还变慢了）
func findNumberIn2DArray2(matrix [][]int, target int) bool {
	down, right := 0, 0
	row := len(matrix)
	// []
	if row == 0 {
		return false
	}
	col := len(matrix[0])
	// [[]]
	if col == 0 {
		return false
	}
	// 极端条件
	if matrix[row-1][col-1] < target {
		return false
	}
	// 排除了极端条件，则一定可以找到斜线上某个值满足条件
	for matrix[down][right] < target {
		if down < row-1 {
			down++
		}
		if right < col-1 {
			right++
		}
	}
	x := down
	for x < row {
		for y := 0; y < col; y++ {
			if matrix[x][y] == target {
				return true
			}
		}
		x++
	}
	x = down
	for x >= 0 {
		for y := right; y < col; y++ {
			if matrix[x][y] == target {
				return true
			}
		}
		x--
	}
	return false
}

// 题解：标志数
func findNumberIn2DArray3(matrix [][]int, target int) bool {
	row := len(matrix)
	// []
	if row == 0 {
		return false
	}
	col := len(matrix[0])
	// [[]]
	if col == 0 {
		return false
	}

	// 遍历方向：左下 -> 右上
	down, right := row-1, 0
	for down >= 0 && right < col {
		if matrix[down][right] > target {
			down--
		} else if matrix[down][right] < target {
			right++
		} else {
			return true
		}
	}

	return false
}

func main() {
	val := [][]int{
		{1, 4, 7, 11, 15},
		{2, 5, 8, 12, 19},
		{3, 6, 9, 16, 22},
		{10, 13, 14, 17, 24},
		{18, 21, 23, 26, 30},
	}
	fmt.Printf("findNumberIn2DArray3(val, 26): %v\n", findNumberIn2DArray3(val, 24))

	// val := [][]int{
	// 	{1, 4},
	// 	{2, 5},
	// }

	// fmt.Printf("findNumberIn2DArray3(val, 1): %v\n", findNumberIn2DArray3(val, 4))
}
