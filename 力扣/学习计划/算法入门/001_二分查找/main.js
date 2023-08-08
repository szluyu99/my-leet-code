/**
 * https://leetcode-cn.com/problems/binary-search/
 * 二分查找
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    // return binarySearch0(nums, target, 0, nums.length - 1)
    return binarySearch1(nums, target, 0, nums.length)
};

/**
 * 在 nums 的 [left, right] 中搜索 target, 返回搜索到值的索引
 * @param {number[]} nums 执行搜索的目标数组
 * @param {number} target 搜索的目标数
 * @param {number} left 搜索的左边界
 * @param {number} right 搜索的右边界
 * @return {number} 目标数的索引, 不存在返回 -1
 */
var binarySearch0 = function (nums, target, left, right) {
    while (left <= right) {
        let mid = (left + right) >> 1
        if (nums[mid] > target)
            right = mid - 1
        else if (nums[mid] < target)
            left = mid + 1
        else return mid
    }
    return -1
}

/**
 * 在 nums 的 [left, right) 中搜索 target, 返回搜索到值的索引
 */
var binarySearch1 = function (nums, target, left, right) {
    while (left < right) {
        let mid = (left + right) >> 1
        if (nums[mid] > target)
            right = mid
        else if (nums[mid] < target)
            left = mid + 1
        else return mid
    }
    return -1
}