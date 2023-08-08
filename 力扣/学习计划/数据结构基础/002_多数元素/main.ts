/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 */

/**
 * map
 */
let majorityElement = function (nums: number[]): number {
    let map = new Map()
    for (let num of nums)
        map.set(num, (map.get(num) ?? 0) + 1)
    for (let item of map.entries()) {
        if (item[1] > ~~(nums.length / 2)) return item[0]
    }
    return -1
};

/**
 * 数组
 */
majorityElement = function (nums: number[]): number {
    let arr = new Array(1000000).fill(0)
    for (let i = 0; i < nums.length; i++)
        arr[nums[i]]++
    let len = ~~(nums.length / 2)
    for (let i = 0; i < nums.length; i++)
        if (arr[nums[i]] > len) return nums[i];
    return -1;
};

/**
 * 排序
 */
majorityElement = function (nums: number[]): number {
    nums = nums.sort()
    return nums[~~(nums.length / 2)]
};

/**
 * 摩尔投票法
 */
majorityElement = function (nums: number[]): number {
    let vote = 0, selectNum = 0
    for (let num of nums) {
        if (vote == 0) selectNum = num
        vote += (num == selectNum) ? 1 : -1
    }
    return selectNum
}