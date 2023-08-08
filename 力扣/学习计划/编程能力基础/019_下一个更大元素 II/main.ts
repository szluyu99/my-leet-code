/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * 下一个更大元素 II
 */
/**
 * 暴力
 */
let nextGreaterElements = function (nums: number[]): number[] {
    let len = nums.length
    if (len <= 1) return [-1]
    let res = new Array(len).fill(null)
    for (let i = 0; i < len; i++) {
        for (let j = i + 1; j < len + i; j++) {
            if (nums[j % len] > nums[i]) {
                res[i] = nums[j % len]
                break
            }
        }
        if (res[i] == null) res[i] = -1
    }
    return res
};
/**
 * 单调递增栈
 */
nextGreaterElements = function (nums: number[]): number[] {
    let size = nums.length, stack = []
    let res = new Array(nums.length).fill(-1)
    for (let i = 0; i < (size * 2); i++) {
        // 栈不为空, 且当前元素 > 栈顶下标对应的元素
        while (stack.length && nums[i % size] > nums[stack[stack.length - 1]]) {
            // 栈顶下标对应的结果
            res[stack.pop()] = nums[i % size]
            stack.push(i % size)
        }
        return res
    }
}