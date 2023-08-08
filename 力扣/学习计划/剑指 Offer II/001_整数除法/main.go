package main

import (
	"fmt"
	"math"
)

/**
 * https://leetcode-cn.com/problems/xoh6Oh/
 */

// O(logn * logn)
func divide1(a int, b int) int {
	// 处理 -2147483648 / -1 = 2147483648 越界问题
	// math.MaxInt32 == 2147483647
	if a == math.MinInt32 && b == -1 {
		return math.MaxInt32
	}

	sign := 1
	if (a > 0 && b < 0) || (a < 0 && b > 0) {
		sign = -1
	}

	a = abs(a)
	b = abs(b)

	var res int
	for a >= b {
		tmp := b
		num := 1
		for a > (tmp << 1) {
			tmp = tmp << 1 // tmp += tmp
			num = num << 1 // num += num
		}
		a -= tmp
		res += num
	}

	// 题目不允许用乘，且Go没有三目表达式
	if sign == 1 {
		return res
	} else {
		return -res
	}
}

// O(1) TODO...
func divide2(a int, b int) int {
	if a == math.MinInt32 && b == -1 {
		return math.MaxInt32
	}

	sign := 1
	if (a > 0 && b < 0) || (a < 0 && b > 0) {
		sign = -1
	}

	a = abs(a)
	b = abs(b)

	var res int

	return res * sign
}

func abs(num int) int {
	if num < 0 {
		return -num
	}
	return num
}

func main() {
	i := divide2(15, 2)
	fmt.Println(i)
}
