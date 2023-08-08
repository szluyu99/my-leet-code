package main

func nthUglyNumber(n int) int {
	var dp []int = make([]int, n)
	dp[0] = 1 // 最基本的丑数
	i, j, k := 0, 0, 0
	for idx := 1; idx < n; idx++ {
		tmp := minNum(dp[i]*2, dp[j]*3, dp[k]*5)
		if tmp == dp[i]*2 {
			i++
		}
		if tmp == dp[j]*3 {
			j++
		}
		if tmp == dp[k]*5 {
			k++
		}
		dp[idx] = tmp
	}
	return dp[n-1]
}

// 获取 num1, num2, num3 中的最小值
func minNum(num1, num2, num3 int) int {
	if num2 < num1 {
		num1 = num2
	}
	if num3 < num1 {
		return num3
	}
	return num1
}
