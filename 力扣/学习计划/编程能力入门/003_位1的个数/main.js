/**
 * @param {number} n - a positive integer
 * @return {number}
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 暴力(超时)
 */
var hammingWeight = function (n) {
    let count = 0
    while (n != 0) {
        if (n & 1) count++;
        n <<= 1
    }
    return count
};

/**
 * @param {number} n - a positive integer
 * @return {number}
 * 位运算
 */
var hammingWeight = function (n) {
    let count = 0
    while (n != 0) {
        n &= (n - 1)
        count++
    }
    return count
};