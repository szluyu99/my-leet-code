/**
 * https://leetcode-cn.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/solution/
 * @param {number} x
 * @param {number} y
 * @param {number[][]} points
 * @return {number}
 */
 var nearestValidPoint = function(x, y, points) {
    let min = Number.MAX_VALUE, idx = -1
    for (let i = 0; i < points.length; i++) {
        let point = points[i]
        let distance = getManhattanDistance(point, [x, y])
        // 剪枝, 遇到相同坐标直接返回
        if (distance === 0) return i
        // 寻找曼哈顿距离最小的下标(并且是有效点)
        if ((point[0] == x || point[1] == y) && distance < min) {
            min = distance
            idx = i
        }
    }
    return idx
};

/**
 * 计算曼哈顿距离
 * @param {number[]} p1
 * @param {number[]} p2
 * @return {number}
 */
var getManhattanDistance = (p1, p2) => {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]) 
}