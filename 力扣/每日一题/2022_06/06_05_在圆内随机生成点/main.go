package main

import (
	"math"
	"math/rand"
)

// 478. 在圆内随机生成点
// https://leetcode.cn/problems/generate-random-point-in-a-circle/

type Solution struct {
	radius float64
	X      float64
	Y      float64
}

func Constructor(radius float64, x_center float64, y_center float64) Solution {
	return Solution{
		radius: radius,
		X:      x_center,
		Y:      y_center,
	}
}

func (this *Solution) RandPoint() []float64 {
	theta := rand.Float64() * 2 * math.Pi
	len := math.Sqrt(rand.Float64()) * this.radius

	x := this.X + len*math.Cos(theta)
	y := this.Y + len*math.Sin(theta)

	return []float64{x, y}
}
