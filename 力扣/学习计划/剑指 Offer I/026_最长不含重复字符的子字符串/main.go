package main

import (
	"strings"
)

// https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
// 动态规划
func lengthOfLongestSubstring(s string) int {
	if s == "" {
		return 0
	}
	// dp[i] 代表以 s[i]结尾的'不含重复字符的子字符串'
	var dp = make([]string, len(s))
	dp[0] = s[:1]
	max := len(dp[0])
	for i := 1; i < len(s); i++ {
		idx := strings.IndexByte(dp[i-1], s[i])
		if idx == -1 {
			dp[i] = dp[i-1] + string(s[i])
		} else {
			dp[i] = string(dp[i-1][idx+1:]) + string(s[i])
		}
		max = maxInt(max, len(dp[i]))
	}
	return max
}

func maxInt(a int, b int) int {
	if a < b {
		return b
	}
	return a
}
