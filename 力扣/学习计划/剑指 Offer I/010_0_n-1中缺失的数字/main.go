package main

// https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/

// 迭代
func missingNumber(nums []int) int {
	length := len(nums)
	if nums[0] != 0 {
		return 0
	}
	if nums[length-1] == length-1 {
		return length
	}
	for i := 1; i < length; i++ {
		if nums[i]-nums[i-1] != 1 {
			return nums[i] - 1
		}
	}
	return -1
}

// 二分搜索
func missingNumber2(nums []int) int {
	length := len(nums)
	// 首尾边界
	if nums[0] != 0 {
		return 0
	}
	if nums[length-1] == length-1 {
		return length
	}

	left, right := 0, length-1
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] <= mid {
			left = mid + 1
		} else if nums[mid] > mid {
			right = mid - 1
		}
		if nums[mid+1]-nums[mid] != 1 {
			return nums[mid] + 1
		}
	}

	return -1
}

// 真正的二分
func missingNumber3(nums []int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := (left + right) >> 1
		if nums[mid] == mid {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return left
}
