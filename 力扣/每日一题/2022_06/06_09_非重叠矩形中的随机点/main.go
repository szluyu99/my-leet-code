package main

import (
	"math/rand"
	"sort"
)

// https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
// 497. 非重叠矩形中的随机点

type Solution struct {
	Rect  [][]int
	Seats []int
	Total int
}

func Count(rect []int) int {
	return (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1)
}

func Constructor(rects [][]int) Solution {
	s := Solution{rects, make([]int, len(rects)), 0}
	for i := range rects {
		s.Seats[i] = s.Total
		s.Total += Count(rects[i])
	}
	return s
}

func (this *Solution) Pick() []int {
	r := rand.Intn(this.Total)
	rect_idx := sort.Search(len(this.Rect), func(index int) bool {
		return r < this.Seats[index]
	}) - 1
	offset := r - this.Seats[rect_idx]
	rect := this.Rect[rect_idx]
	x := offset / (rect[3] - rect[1] + 1)
	y := offset % (rect[3] - rect[1] + 1)
	return []int{rect[0] + x, rect[1] + y}
}
