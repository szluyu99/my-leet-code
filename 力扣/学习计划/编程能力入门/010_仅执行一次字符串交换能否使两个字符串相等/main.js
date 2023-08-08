/**
 * https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal/
 * 仅执行一次字符串交换能否使两个字符串相等
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 * count 记录不同的字符的个数，必须为 2
 *      循环过程中发现大于 2 直接返回（剪枝操作），比如 "aaaxyz" "bbbxyz"
 *      循环结束发现只有 1 个字符不同，肯定无法交换成一样的，比如 "aa" "ab"
 * 由于确定不同字符个数必须为 2，idx1, idx2 分别记录位置
 *      循环结束后，查看 s1[idx2] 是否等于 s2[idx1]，s2[idx1] 是否等于 s1[idx2]
 */
var areAlmostEqual = function (s1, s2) {
    let count = 0, idx1 = -1, idx2 = -1
    for (let i in s1) {
        if (s1[i] != s2[i]) {
            idx1 < 0 ? idx1 = i : idx2 = i
            count++
        }
        if (count > 2) return false
    }
    if (count == 1) return false;
    return s1[idx1] == s2[idx2] && s1[idx2] == s2[idx1]
};