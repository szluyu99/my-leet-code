package main

// https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/

// 暴力
func maxProfit(prices []int) int {
	max := 0
	for i := len(prices) - 1; i >= 0; i-- {
		for j := 0; j < i; j++ {
			tmp := prices[i] - prices[j]
			if tmp > max {
				max = tmp
			}
		}
	}
	return max
}
