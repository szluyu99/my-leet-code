package main

func isBoomerang(points [][]int) bool {
	x0, x1, x2 := points[0][0], points[1][0], points[2][0]
	y0, y1, y2 := points[0][1], points[1][1], points[2][1]
	// 斜率计算会有除 0 问题
	// (y1 - y0) / (x1 - x0) != (y2 - y1) / (x2 - x1)
	// 公式变形为乘法, 则没有除 0 问题
	// (y1 - y0) * (x2 - x1) != (y2 - y1) * (x1 - x0)
	k1, k2 := (y1-y0)*(x2-x1), (y2-y1)*(x1-x0)
	return k1 != k2
}
