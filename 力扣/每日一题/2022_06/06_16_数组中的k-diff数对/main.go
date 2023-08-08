// https://leetcode.cn/problems/k-diff-pairs-in-an-array/
// 532. 数组中的 k-diff 数对
package main

func findPairs(nums []int, k int) (count int) {
	if k < 0 {
		return 0
	}

	m := make(map[int]int)

	for _, v := range nums {
		m[v]++
	}

	for v, num := range m {
		if _, ok := m[v+k]; ok {
			if k == 0 && num < 2 {
				continue
			}
			count++
		}
	}

	return count
}
