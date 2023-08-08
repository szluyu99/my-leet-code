package main

import "math"

// 动态规划
func maxSubArray(nums []int) int {
	var dp = make([]int, len(nums))
	dp[0] = nums[0]
	max := dp[0]
	for i := 1; i < len(nums); i++ {
		if dp[i-1] > 0 {
			dp[i] = dp[i-1] + nums[i]
		} else {
			dp[i] = nums[i]
		}
		max = int(math.Max(float64(max), float64(dp[i])))
	}
	return max
}
