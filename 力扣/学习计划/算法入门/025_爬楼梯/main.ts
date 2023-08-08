/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯
 */

/**
 * 递归(超时)
 */
let climbStairs = function (n: number): number {
    if (n <= 2) return n
    return climbStairs(n - 1) + climbStairs(n - 2)
};

/**
 * 动态规划
 */
climbStairs = function (n: number): number {
    let dp = new Array(n + 1)
    dp[1] = 1
    dp[2] = 2
    for (let i = 3; i <= n; i++)
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp[n]
}

/**
 * 优化空间复杂度
 */
climbStairs = function (n: number): number {
    if (n <= 2) return n
    let first = 1, second = 2
    for (let i = 3; i <= n; i++) {
        second = first + second
        first = second - first
    }
    return second
};

////////////////////

/**
 * 记忆化递归
 */
climbStairs = function (n: number): number {
    if (n <= 2) return n
    let memory = new Array(n + 1).fill(0)
    memory[1] = 1
    memory[2] = 2
    recur(n, memory)
    return recur(n, memory)
};

const recur = function (n: number, mem: number[]): number {
    if (mem[n] == 0)
        mem[n] = recur(n - 1, mem) + recur(n - 2, mem)
    return mem[n]
}