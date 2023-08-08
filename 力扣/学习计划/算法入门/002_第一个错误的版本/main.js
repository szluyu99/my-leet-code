/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * 第一个错误的版本
 * @param {function} isBadVersion()
 * @return {function}
 */
var solution = function (isBadVersion) {
    /**
     * @param {integer} n Total versions
     * @return {integer} The first bad version
     */
    return function (n) {
        let left = 1, right = n
        while (left < right) {
            let mid = ~~(left + (right - left) / 2)
            isBadVersion(mid) ? right = mid : left = mid + 1
        }
        return left
    };
};