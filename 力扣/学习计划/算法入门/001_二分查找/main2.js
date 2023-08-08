/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    return binarySearch(nums, target, 0, nums.length - 1)
};

var binarySearch = function (nums, target, left, right) {
    if (left > right) return -1
    let mid = (left + right) >> 1
    if (nums[mid] == target) return mid;
    return nums[mid] < target
        ? binarySearch(nums, target, mid + 1, right)
        : binarySearch(nums, target, left, mid - 1)
}