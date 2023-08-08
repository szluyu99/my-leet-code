/**
 * @param {number[][]} grid
 * @return {number}
 * 不使用全局变量
 */
var maxAreaOfIsland = function (grid) {
    let max = -1
    for (let i = 0; i < grid.length; i++)
        for (let j = 0; j < grid[0].length; j++)
            max = Math.max(max, dfs(grid, i, j))
    return max
};

const dfs = (grid, cr, cc) => {
    // 越界
    if (cr < 0 || cr >= grid.length || cc < 0 || cc >= grid[0].length) return 0
    // 已访问过, 或者不是岛屿
    if (grid[cr][cc] === -1 || grid[cr][cc] === 0) return 0

    // 面积+1, 并标记已经访问
    grid[cr][cc] = -1

    let area = 1
    area += dfs(grid, cr - 1, cc) // 上
    area += dfs(grid, cr, cc + 1) // 右
    area += dfs(grid, cr + 1, cc) // 下
    area += dfs(grid, cr, cc - 1) // 左
    return area
}