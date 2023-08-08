/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 * https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range/
 * 暴力
 */
var countOdds = function (low, high) {
    let count = 0;
    for (let i = low; i <= high; i++) {
        if (i & 1 == 1) count++
    }
    return count
};

/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 * 数学(分情况找规律推算)
 */
 var countOdds = function (low, high) {
    if (low & 1 === 1 && high & 1 === 1)
        return 1 + (high - low) / 2
    return (high - low) / 2
};