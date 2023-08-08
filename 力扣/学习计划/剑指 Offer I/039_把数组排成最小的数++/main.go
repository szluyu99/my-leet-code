package main

import (
	"fmt"
	"sort"
)

// API + 自定义排序规则
func minNumber(nums []int) string {
	// 将整数数组按字符串形式排序
	sort.Slice(nums, func(i, j int) bool {
		x := fmt.Sprintf("%d%d", nums[i], nums[j])
		y := fmt.Sprintf("%d%d", nums[j], nums[i])
		return x < y
	})
	res := ""
	for _, v := range nums {
		res += fmt.Sprintf("%d", v)
	}
	return res
}
