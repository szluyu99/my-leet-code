package main

// 动态规划
func fib(n int) int {
	if n <= 1 {
		return n
	}
	dp := make([]int, 2)
	dp[0], dp[1] = 0, 1
	for i := 2; i <= n; i++ {
		dp[i] = (dp[i-1] + dp[i-2]) % 1000000007
	}
	return dp[n]
}
