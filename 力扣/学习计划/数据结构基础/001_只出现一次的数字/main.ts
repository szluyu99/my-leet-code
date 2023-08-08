/**
 * https://leetcode-cn.com/problems/single-number/
 * 只出现一次的数字
 */
function singleNumber(nums: number[]): number {
    let res = 0
    for (let num of nums) res ^= num
    return res
};