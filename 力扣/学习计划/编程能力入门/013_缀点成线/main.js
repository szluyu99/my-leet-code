/**
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 * 缀点成线
 * @param {number[][]} coordinates
 * @return {boolean}
 * 数学 + 模拟
 */
var checkStraightLine = function (coordinates) {
    // 取两个点来决定 fx 方程
    let p1 = coordinates[0], p2 = coordinates[1]

    // x = a
    if (p1[0] - p2[0] == 0) {
        for (let coordinate of coordinates)
            if (coordinate[0] != p1[0])
                return false
        return true
    }

    // y = b
    if (p1[1] - p2[1] == 0) {
        for (let coordinate of coordinates)
            if (coordinate[1] != p1[1])
                return false
        return true
    }

    // y = kx + b
    let k = (p1[1] - p2[1]) / (p1[0] - p2[0])
    let b = p1[1] - k * p1[0] // b = y - kx
    const fx = (x, k, b) => k * x + b
    for (let coordinate of coordinates)
        if (coordinate[1] != fx(coordinate[0], k, b))
            return false
    return true
};