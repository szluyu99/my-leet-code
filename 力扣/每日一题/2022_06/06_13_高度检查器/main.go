package main

import (
	"sort"
)

// https://leetcode.cn/problems/height-checker/
// 高度检查器

func heightChecker(heights []int) int {
	sortedHeights := make([]int, len(heights))
	copy(sortedHeights, heights) // 拷贝切片
	sort.Sort(sort.IntSlice(sortedHeights))

	count := 0
	for i, h := range sortedHeights {
		if h != heights[i] {
			count++
		}
	}
	return count
}
