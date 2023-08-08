/**
 * @param {number[]} nums
 * @return {number}
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * 排序后遍历相邻元素
 */
var largestPerimeter = function (nums) {
    nums = nums.sort((a, b) => b - a)
    for (let i = 2; i < nums.length; i++) {
        let a = nums[i - 2], b = nums[i - 1], c = nums[i]
        if (b + c > a)
            return a + b + c
    }
    return 0
};