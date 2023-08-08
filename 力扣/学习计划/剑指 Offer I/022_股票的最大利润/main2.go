package main

import "math"

// 题解：动态规划
func maxProfit(prices []int) int {
	// dp(n) = Math.max(dp(n - 1), prices[n] - min)
	// 第n天最大利润等于 第n-1天最大利润 跟 第n天股票价格和股票历史最低价的差值 相比
	size := len(prices)
	if size < 2 {
		return 0
	}
	dp := make([]int, size)
	dp[0] = 0
	min := prices[0]
	for i := 1; i < size; i++ {
		if prices[i] < min {
			min = prices[i]
		}
		dp[i] = int(math.Max(float64(dp[i-1]), float64(prices[i]-min)))
	}
	return dp[size-1]
}
