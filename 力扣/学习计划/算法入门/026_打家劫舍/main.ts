/**
 * https://leetcode-cn.com/problems/house-robber/
 * 打家劫舍
 */

/**
 * 动态规划1
 * （不标准的动态规划）
 */
let rob = function (nums: number[]): number {
    if (nums.length == 1) return nums[0]
    if (nums.length == 2) return Math.max(nums[0], nums[1])
    // dp[i] 偷窃第 i 号房屋的最高金额
    let dp = new Array(nums.length)
    dp[0] = nums[0]
    dp[1] = nums[1]

    for (let i = 2; i < nums.length; i++) {
        let tmpMax = 0
        // 寻找偷窃前面某家的最大值
        for (let j = 0; j <= i - 2; j++)
            tmpMax = Math.max(tmpMax, dp[j])
        // 偷窃第 i 家的最高金额 = max{ 偷窃第 i -1 家的金额, 偷窃前面某家的最大值 + 当前这家 }
        dp[i] = Math.max(dp[i - 1], tmpMax + nums[i])
    }

    return dp[nums.length - 1]
};

/**
 * 动态规划1（优化）
 * （不标准的动态规划）
 */
rob = function (nums: number[]): number {
    if (nums.length == 1) return nums[0]
    if (nums.length == 2) return Math.max(nums[0], nums[1])
    // dp[i] 偷窃第 i 号房屋的最高金额
    let dp = new Array(nums.length)
    dp[0] = nums[0]
    dp[1] = nums[1]

    let tmpMax = 0 // 偷窃前面某家的最大值
    for (let i = 2; i < nums.length; i++) {
        // 偷窃第 i 家的最高金额 = max{ 偷窃第 i -1 家的金额, 偷窃前面某家的最大值 + 当前这家 }
        tmpMax = Math.max(tmpMax, dp[i - 2])
        dp[i] = Math.max(dp[i - 1], tmpMax + nums[i])
    }

    return dp[nums.length - 1]
};

/**
 * 动态规划2
 */
rob = function (nums: number[]): number {
    if (nums.length == 1) return nums[0]
    if (nums.length == 2) return Math.max(nums[0], nums[1])
    // dp[i] 偷窃第 i 号房屋的最高金额
    let dp = new Array(nums.length)
    dp[0] = nums[0]
    dp[1] = Math.max(nums[0], nums[1])

    for (let i = 2; i < nums.length; i++)
        // 偷窃第 i 家的最高金额 = 
        // max{ 偷窃第 i -1 家的最大值, 偷窃第 i -2 家的最大值 + nums[i] }
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])

    return dp[nums.length - 1]
}

/**
 * 递归
 */
rob = function (nums: number[]): number {
    return robTo(nums, nums.length - 1)
}

const robTo = function (nums: number[], lastIndex: number) {
    if (lastIndex == 0) return 0
    return Math.max(robTo(nums, lastIndex - 2) + nums[lastIndex], robTo(nums, lastIndex - 1))
}