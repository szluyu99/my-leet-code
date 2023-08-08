/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 * 双指针
 */
var moveZeroes = function (nums) {
    let left = 0, right = 0
    while (right < nums.length) {
        if (nums[right] != 0)
            nums[left++] = nums[right]
        right++
    }
    nums.fill(0, left, nums.length)
};

var moveZeroes = function (nums) {
    let left = 0, right = 0
    while (right < nums.length) {
        if (nums[right] != 0) {
            [nums[left], nums[right]] = [nums[right], nums[left]]
            left++
        }
        right++
    }
}