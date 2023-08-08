/**
 * https://leetcode-cn.com/problems/sign-of-the-product-of-an-array/comments/
 * 数组元素积的符号
 * @param {number[]} nums
 * @return {number}
 * reduce 一行
 */
var arraySign = function (nums) {
    return nums.reduce((pre, cur) => pre * (cur > 0 ? 1 : (cur < 0 ? -1 : 0)), 1)
};

/**
 * 迭代
 */
 var arraySign = function(nums) {
    let res = 1
    for (let i = 0; i < nums.length; i++) {
        // 剪枝
        if (nums[i] == 0) return 0;
        res *= nums[i] > 0 ? 1 : -1
    }
    return res
};