package main

// https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/

// 递归
func numWays0(n int) int {
	if n <= 1 {
		return 1
	}
	return numWays0(n-1) + numWays0(n-2)
}

// 动态规划
func numWays(n int) int {
	if n <= 1 {
		return 1
	}
	dp := make([]int, n+1)
	dp[0], dp[1] = 1, 1
	for i := 2; i <= n; i++ {
		dp[i] = (dp[i-1] + dp[i-2]) % 1000000007
	}
	return dp[n]
}

// 动态规划 优化
func numWays1(n int) int {
	a, b := 1, 1
	for i := 0; i < n; i++ {
		sum := (a + b) % 1000000007
		a = b
		b = sum
	}
	return a
}

// 迭代
func numWays2(n int) int {
	if n <= 1 {
		return 1
	}
	a, b := 1, 2
	for i := 2; i < n; i++ {
		b = (a + b)
		a = b - a
		b %= 1000000007
	}
	return b
}
