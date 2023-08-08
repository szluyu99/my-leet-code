/**
 * https://leetcode-cn.com/problems/rotate-array/
 * 轮转数组
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
    let len = nums.length
    let res = new Array(len)
    for (let i = 0; i < len; i++)
        res[(i + k) % len] = nums[i]
    nums.splice(0, len, ...res)
};

/**
 * splice
 */
var rotate = function (nums, k) {
    nums.splice(0, 0, ...nums.splice(-(k % nums.length)))
};

/**
 * unshift + splice
 */
var rotate = function (nums, k) {
    const len = nums.length
    nums.unshift(...nums.splice(len - k % len))
};

/**
 * 反转 3 次数组
 */
var rotate = function (nums, k) {
    k %= nums.length

    reverse(nums, 0, nums.length - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, nums.length - 1)
}

/**
 * 反转数组
 */
let reverse = (nums, start, end) => {
    while (start < end)
        [nums[start++], nums[end--]] = [nums[end], nums[start]]
}