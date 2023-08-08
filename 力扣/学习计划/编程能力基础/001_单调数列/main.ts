/**
 * 递归(超时)
 */
function isMonotonic(nums: number[]): boolean {
    return nums[0] < nums[nums.length - 1] ?
        isMonotonicIncrease(nums) : isMonotonicDecrease(nums)
};

// 递归判断是否单调递
const isMonotonicIncrease = function (nums: number[]): boolean {
    if (nums.length == 1) return true
    if (nums[0] > nums[1]) return false
    return isMonotonicIncrease(nums.slice(1)) ? true : false
}

// 递归判断是否单调减
const isMonotonicDecrease = function (nums: number[]): boolean {
    if (nums.length == 1) return true
    if (nums[0] < nums[1]) return false
    return isMonotonicDecrease(nums.slice(1)) ? true : false
}
