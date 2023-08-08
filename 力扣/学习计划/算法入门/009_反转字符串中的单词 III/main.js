/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 反转字符串中的单词 III 
 * @param {string} s
 * @return {string}
 * 高阶函数
 */
var reverseWords = function (s) {
    return s.split(" ").map(s => s.split("").reverse().join("")).join(" ")
};