package main

// 二分搜索
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

	// 二分搜索
	for l <= r {
		m := l + (r-l)>>1
		if canEatAll(m) {
			r = m - 1
		} else {
			l = m + 1
		}
	}
	return l
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
