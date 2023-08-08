package main

// https://leetcode.cn/problems/flip-string-to-monotone-increasing/
// 926. 将字符串翻转到单调递增

// dp
func minFlipsMonoIncr(s string) (ans int) {
	n := len(s)

	// 二维数组
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, 2)
	}

	for i, c := range s {
		if c == '1' {
			// 遍历到 1，基于前面元素为 0 会翻转到 0
			dp[i+1][0] = dp[i][0] + 1
			// 遍历到 1，不用翻转
			dp[i+1][1] = min(dp[i][0], dp[i][1])
		} else {
			// 遍历到 0，不用翻转保持 0
			dp[i+1][0] = dp[i][0]
			// 遍历到 0，需要翻转
			dp[i+1][1] = min(dp[i][0], dp[i][1]) + 1
		}
	}

	return min(dp[n][0], dp[n][1])
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
