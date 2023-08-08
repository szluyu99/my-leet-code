var isMonotonic = function (nums) {
    return isSorted(nums) || isSorted(nums.reverse())
}
function isSorted(nums) {
    return nums.slice(1).every((item, i) => nums[i] <= item)
}