package main

// https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/

// 哈希
func twoSum(nums []int, target int) []int {
	dic := make(map[int]bool)
	for _, num := range nums {
		if _, ok := dic[target-num]; ok {
			return []int{num, target - num}
		}
		dic[num] = true
	}
	return []int{}
}
