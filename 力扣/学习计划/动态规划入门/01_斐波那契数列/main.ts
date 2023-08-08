/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * 斐波那契数
 */
/**
 * DP
 */
let fib = function (n: number): number {
    let dp = new Array(n + 1)
    dp[0] = 0
    dp[1] = 1
    for (let i = 2; i <= n; i++)
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp[n]
};

/**
 * 动规优化
 */
fib = function (n: number): number {
    let first = 0, second = 1
    for (let i = 0; i <= n; i++) {
        first = first + second
        second = first - second
    }
    return second
}