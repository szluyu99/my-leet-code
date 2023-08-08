package main

import "fmt"

// https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

// 迭代 + map
func findRepeatNumber(nums []int) int {
	m := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if val, ok := m[nums[i]]; ok {
			return val
		}
		m[nums[i]] = nums[i]
	}
	return 0
}

// 迭代 + 切片
func findRepeatNumber2(nums []int) int {
	records := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		records[nums[i]]++
		if records[nums[i]] > 1 {
			return nums[i]
		}
	}
	return 0
}

// 题解：原地交换
func findRepeatNumber3(nums []int) int {
	i := 0
	for i < len(nums) {
		if nums[i] == nums[nums[i]] {
			i++
			continue
		}
		tmp := nums[i]
		nums[i] = nums[nums[i+1]]
		nums[nums[i+1]] = tmp
	}
	return -1
}

func main() {
	// findRepeatNumber(nil)
	m := make(map[string]interface{})
	m["a"] = "AAA"
	if _, ok := m["ba"]; ok {
		fmt.Println("存在")
	} else {
		fmt.Println("不存在")
	}
}
