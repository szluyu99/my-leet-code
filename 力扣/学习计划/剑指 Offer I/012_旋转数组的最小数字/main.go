package main

// 题解：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/

// 暴力迭代1
func minArray(numbers []int) int {
	if len(numbers) == 1 {
		return numbers[0]
	}
	for i := 1; i < len(numbers); i++ {
		if numbers[i] < numbers[i-1] {
			return numbers[i]
		}
	}
	return numbers[0]
}

// 暴力迭代2
func minArray4(numbers []int) int {
	for i := 0; i < len(numbers); i++ {
		if numbers[i] < numbers[0] {
			return numbers[i]
		}
	}
	return numbers[0]
}

// 题解：二分1
func minArray2(number []int) int {
	left, right := 0, len(number)-1
	for left < right {
		mid := left + (right-left)>>1
		if number[mid] < number[right] {
			right = mid
		} else if number[mid] > number[right] {
			left = mid + 1
		} else {
			right--
		}
	}
	return number[left]
}

// 题解：二分2
func minArray3(numbers []int) int {
	left, right := 0, len(numbers)-1
	for left < right {
		mid := left + (right-left)>>1
		if numbers[mid] < numbers[right] {
			right--
		} else if numbers[mid] > numbers[right] {
			left = mid + 1
		}
	}
	return numbers[left]
}

// 我写的假二分，表明我对二分的理解还不够到位（这个跑不通）
func minArray1(numbers []int) int {
	if len(numbers) == 1 {
		return numbers[0]
	}

	left, right := 0, len(numbers)-1
	for left < right {
		mid := left + (right-left)>>1
		if mid-1 < 0 {
			if numbers[0] < numbers[1] {
				return numbers[0]
			}
			if numbers[0] > numbers[1] {
				return numbers[1]
			}
		}
		if numbers[mid] < numbers[mid-1] {
			return numbers[mid]
		} else if numbers[mid] < numbers[len(numbers)-1] {
			right = mid
		} else if numbers[mid] > numbers[0] {
			left = mid + 1
		}
	}
	return numbers[0]
}
