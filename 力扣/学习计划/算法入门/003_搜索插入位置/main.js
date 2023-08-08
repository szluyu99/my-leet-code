/**
 * https://leetcode-cn.com/problems/search-insert-position/submissions/
 * 搜索插入位置
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
    let left = 0, right = nums.length
    while (left <= right) {
        let mid = ~~(left + (right - left) / 2)
        if (nums[mid] > target)
            right = mid - 1
        else if (nums[mid] < target)
            left = mid + 1
        else return mid
    }
    return left
};