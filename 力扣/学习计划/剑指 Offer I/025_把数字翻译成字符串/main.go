package main

import (
	"strconv"
)

// https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
// 动态规划
func translateNum(num int) int {
	// dp[i] - 以Xi结尾的数字的翻译方案
	numStr := strconv.Itoa(num)
	var dp = make([]int, len(numStr)+1)
	dp[0], dp[1] = 1, 1
	for i := 2; i <= len(numStr); i++ {
		// 最后两位组成的数字
		tmp := int(numStr[i-2]-'0')*10 + int(numStr[i-1]-'0')
		if tmp >= 10 && tmp <= 25 {
			dp[i] = dp[i-1] + dp[i-2]
		} else {
			dp[i] = dp[i-1]
		}
	}
	return dp[len(numStr)]
}
