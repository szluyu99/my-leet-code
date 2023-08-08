package main

// https://leetcode.cn/problems/koko-eating-bananas/
// 爱吃香蕉的珂珂

// 暴力查找 - 超时
func minEatingSpeed(piles []int, h int) int {
	l, r := 1, max(piles)

	// 判断以某个速度是否能在 h 小时内吃掉全部香蕉
	canEatAll := func(v int) bool {
		time := 0
		for _, n := range piles {
			// 时间 = 数量 / 速度
			if n%v == 0 {
				time += n / v
			} else {
				time += n/v + 1
			}
		}
		return time <= h
	}

	// 暴力搜索 - 超时
	for i := l; i <= r; i++ {
		if canEatAll(i) {
			return i
		}
	}
	return -1
}

func max(nums []int) int {
	res := nums[0]
	for _, v := range nums {
		if v > res {
			res = v
		}
	}
	return res
}
