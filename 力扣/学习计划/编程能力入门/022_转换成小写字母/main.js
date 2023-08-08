/**
 * https://leetcode-cn.com/problems/to-lower-case/
 * 转换成小写字母
 * @param {string} s
 * @return {string}
 */
var toLowerCase = function (s) {
    return [...s].map(e => e >= 'A' && e <= 'Z' ? e.toLowerCase() : e).join('')
};