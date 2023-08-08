/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 344. 反转字符串
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function (s) {
    let left = 0, right = s.length - 1
    while (left <= right)
        [s[left++], s[right--]] = [s[right], s[left]]
}

var reverseString = function (s) {
    s.reverse()
};

var reverseString = function (s) {
    var help = (s, left, right) => {
        if (left >= right) return
        [s[left], s[right]] = [s[right], s[left]]
        help(s, ++left, --right)
    }
    help(s, 0, s.length - 1)
};