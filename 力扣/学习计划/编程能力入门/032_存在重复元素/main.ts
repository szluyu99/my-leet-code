/**
 * https://leetcode-cn.com/problems/contains-duplicate/submissions/
 * 217. 存在重复元素 
 */
let containsDuplicate = function (nums: number[]): boolean {
    let set = new Set<number>()
    for (let num of nums) {
        if (set.has(num)) return true
        set.add(num)
    }
    return false
};

containsDuplicate = function (nums: number[]): boolean {
    return new Set(nums).size < nums.length
}

