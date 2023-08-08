package main

// https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
func hammingWeight(num uint32) int {
	res := 0
	for num > 0 {
		if num&1 == 1 {
			res++
		}
		num >>= 1
	}
	return res
}
