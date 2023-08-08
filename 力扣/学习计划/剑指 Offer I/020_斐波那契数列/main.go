package main

// https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

func fib(n int) int {
	first, second := 0, 1
	for i := 0; i < n; i++ {
		second = first + second
		first = second - first
		first %= 1000000007
	}
	return first
}

func fib2(n int) int {
	a, b := 0, 1
	for i := 0; i < n; i++ {
		b, a = a+b, b%1000000007
	}
	return a
}
