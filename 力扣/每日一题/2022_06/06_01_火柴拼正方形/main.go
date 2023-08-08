package main

import "sort"

// 火柴拼正方形
// https://leetcode.cn/problems/matchsticks-to-square/

// dfs - 暴力超时
func makesquare(nums []int) bool {
	sum := 0
	for _, num := range nums {
		sum += num
	}

	// 剪枝: 长度不为 4 的倍数必然不可能
	if sum%4 != 0 {
		return false
	}

	// 不超时的关键 --- 倒序排序
	sort.Sort(sort.Reverse(sort.IntSlice(nums)))

	return dfs(nums, 0, len(nums), 0, 0, 0, 0, sum/4)
}

// i5 为要寻找的结果边长
func dfs(nums []int, i, length, i1, i2, i3, i4, i5 int) bool {
	// 超过要寻找的边长 不可能
	if i1 > i5 || i2 > i5 || i3 > i5 || i4 > i5 {
		return false
	}

	// 计数器 == 数组长度, 要么满足条件, 要么不满足条件
	if i == length {
		if i1 == i5 && i2 == i5 && i3 == i5 && i4 == i5 {
			return true
		}
		return false
	}

	return dfs(nums, i+1, length, i1+nums[i], i2, i3, i4, i5) ||
		dfs(nums, i+1, length, i1, i2+nums[i], i3, i4, i5) ||
		dfs(nums, i+1, length, i1, i2, i3+nums[i], i4, i5) ||
		dfs(nums, i+1, length, i1, i2, i3, i4+nums[i], i5)
}
