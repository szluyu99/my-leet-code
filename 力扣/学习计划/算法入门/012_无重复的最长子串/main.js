/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 * @param {string} s
 * @return {number}
 * 滑动窗口
 */
var lengthOfLongestSubstring = function (s) {
    let set = new Set(), max = 0
    let left = 0, right = 0
    while (right < s.length) {
        let c = s[right]
        while (set.has(c))
            set.delete(s[left++])
        set.add(s[right])
        max = Math.max(max, right - left + 1)
        right++
    }
    return max
};