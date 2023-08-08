package main

import "fmt"

// https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/

// 迭代
func search(nums []int, target int) int {
	var count int
	for _, v := range nums {
		if v > target {
			break
		}
		if target == v {
			count++
		}

	}
	return count
}

// 二分查找
func search2(nums []int, target int) int {
	var count int
	start, end := 0, len(nums)
	for start < end {
		mid := (start + end) / 2
		if target < nums[mid] {
			end = mid
		} else if target > nums[mid] {
			start = mid + 1
		} else {
			count++
			// behind
			idx := mid + 1
			for idx < len(nums) {
				if nums[idx] == target {
					count++
					idx++
				} else {
					break
				}
			}
			// front
			idx = mid - 1
			for idx >= 0 {
				if nums[idx] == target {
					count++
					idx--
				} else {
					break
				}
			}
			return count
		}
	}
	return 0
}

// 题解：二分查找
func search3(nums []int, target int) int {
	left, right := 0, len(nums)-1
	var count int
	for left < right {
		mid := (left + right) / 2
		if nums[mid] >= target {
			right = mid
		}
		if nums[mid] < target {
			left = mid + 1
		}
	}
	for left < len(nums) && nums[left] == target {
		count++
		left++
	}
	return count
}

func main() {
	r := search2([]int{5, 7, 7, 8, 8, 10}, 9)
	fmt.Printf("r: %v\n", r)
}
