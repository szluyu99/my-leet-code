/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
    let idx = 0, len = nums.length, count = 0
    while (count < len) {
        if (nums[idx] == 0)
            nums.push(nums.splice(idx, 1))
        else idx++
        count++
    }
};

/**
 * 双指针
 * 思路：
 *  遍历时将整数全部移动到前面, 剩下的补0
 *  left 记录不为0的数字个数
 */
var moveZeroes = function (nums) {
    let left = 0, right = 0
    while (right < nums.length) {
        if (nums[right] != 0)
            nums[left++] = nums[right]
        right++
    }
    while (left < nums.length)
        nums[left++] = 0
};

/**
 * 双指针一轮循环
 * 思路：
 *  遍历时 right 遇到不为0的数字, 就和前面为0的 left 交换
 *  遇到为0的数字, left 不动, right 继续往前
 */
var moveZeroes = function (nums) {
    let left = 0, right = 0
    while (right < nums.length) {
        if (nums[right] != 0) {
            if (nums[left] == 0) {
                [nums[left], nums[right]] = [nums[right], nums[left]]
            }
            left++
        }
        right++
    }
};