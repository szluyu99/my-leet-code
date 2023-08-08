package main

// 递归
func translateNum(num int) int {
	if num < 10 {
		return 1
	}
	if num%100 >= 10 && num%100 <= 25 {
		return translateNum(num/100) + translateNum(num/10)
	} else {
		return translateNum(num / 10)
	}
}
