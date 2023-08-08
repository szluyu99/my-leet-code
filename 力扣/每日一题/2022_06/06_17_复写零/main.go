package main

// https://leetcode.cn/problems/duplicate-zeros/
// 1089. 复写零

func duplicateZeros(arr []int) {
	temp := make([]int, len(arr))

	idx := 0
	for _, n := range arr {
		if idx == len(arr) {
			break
		}
		if n == 0 && idx != len(arr)-1 {
			temp[idx] = 0
			temp[idx+1] = 0
			idx++
		} else {
			temp[idx] = n
		}
		idx++
	}
	for i := 0; i < len(temp); i++ {
		arr[i] = temp[i]
	}
}
