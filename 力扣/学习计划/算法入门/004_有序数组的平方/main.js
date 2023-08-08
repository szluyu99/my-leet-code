/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 有序数组的平方
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function (nums) {
    return nums.map(n => n * n).sort((a, b) => a - b)
};

/**
 * 双指针
 */
var sortedSquares = function (nums) {
    let left = 0, right = nums.length - 1, idx = right
    let res = new Array(nums.length)
    while (left <= right) {
        if (Math.pow(nums[left], 2) > Math.pow(nums[right], 2))
            res[idx--] = Math.pow(nums[left++], 2)
        else
            res[idx--] = Math.pow(nums[right--], 2)
    }
    return res
};
