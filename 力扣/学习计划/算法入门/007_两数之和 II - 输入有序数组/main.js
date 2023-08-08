/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/submissions/
 * 两数之和 II - 输入有序数组 
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {
    let map = new Map()
    numbers.forEach((val, i) => map.set(val, i))
    for (let i = 0; i < numbers.length; i++)
        if (map.has(target - numbers[i]))
            return [i + 1, map.get(target - numbers[i]) + 1]
    return []
};


/**
 * 二分
 */
var twoSum = function (numbers, target) {
    for (let i = 0; i < numbers.length; i++) {
        let idx = leftBoundBinarySearch(numbers, target - numbers[i], i + 1, numbers.length - 1)
        if (idx !== -1) return [i + 1, idx + 1]
    }
    return []
};

/**
 * 寻找左边界的二分搜索
 */
const leftBoundBinarySearch = (nums, target, left, right) => {
    while (left <= right) {
        let mid = (left + right) >> 1
        if (nums[mid] >= target)
            right = mid - 1
        else if (nums[mid] < target)
            left = mid + 1
    }
    if (left >= nums.length || nums[left] != target)
        return -1
    return left
}