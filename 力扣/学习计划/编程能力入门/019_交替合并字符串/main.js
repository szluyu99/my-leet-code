/**
 * https://leetcode-cn.com/problems/merge-strings-alternately/
 * 1768. 交替合并字符串
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 * 模拟
 */
var mergeAlternately = function (word1, word2) {
    let chars1 = [...word1], chars2 = [...word2]
    let p1 = 0, p2 = 0, res = []
    while (p1 < chars1.length || p2 < chars2.length) {
        if (p1 < chars1.length) res.push(chars1[p1++])
        if (p2 < chars2.length) res.push(chars2[p2++])
    }
    return res.join("")
};

var mergeAlternately = function (word1, word2) {
    let res = []
    for (let i = 0; i < word1.length || i < word2.length; i++) {
        if (i < word1.length) res.push(word1[i])
        if (i < word2.length) res.push(word2[i])
    }
    return res.join('')
};

