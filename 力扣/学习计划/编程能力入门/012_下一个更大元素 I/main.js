/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * 下一个更大元素 I
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function (nums1, nums2) {
    let res = new Array(nums1.length), idx = 0
    for (let i = 0; i < nums1.length; i++) {
        for (let j = nums2.indexOf(nums1[i]); j < nums2.length; j++) {
            if (nums2[j] > nums1[i]) {
                res[idx++] = nums2[j]
                break
            }
            if (j == nums2.length - 1)
                res[idx++] = -1
        }
    }
    return res
};