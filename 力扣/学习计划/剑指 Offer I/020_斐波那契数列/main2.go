package main

// 记忆化递归
func fib(n int) int {
	if n <= 1 {
		return n
	}
	arr := make([]int, n+1)
	arr[1] = 1
	arr[2] = 1
	return helper(arr, n)
}

func helper(arr []int, n int) int {
	if arr[n] == 0 {
		arr[n] = helper(arr, n-1) + helper(arr, n-2)
	}
	return arr[n] % 1000000007
}
