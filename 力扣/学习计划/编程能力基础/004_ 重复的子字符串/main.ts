/**
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * 459. 重复的子字符串 
 */

/**
 * 模拟
 */
let repeatedSubstringPattern = function (s: string): boolean {
    if (s.length < 2) return false
    // 只需要遍历一半即可, 一半以后必然不能重复
    for (let i = 1; i <= s.length / 2; i++) {
        let sub = s.substring(0, i)
        // 剪枝：字符串的长度不是串的整数倍, 必然不满足条件
        if (s.length % i != 0) continue
        // 剪枝：最后不是以该子串结尾, 必然不满足条件
        if (sub != s.substring(s.length - sub.length)) continue
        // 利用 repeat API, 查看是否满足满足要求
        if (sub.repeat(s.length / sub.length) == s)
            return true
    }
    return false
}

/**
 * 移动字符串
 * [1] s = acd
 * [2] ss = acdacd
 * [3] ss.substring(1, ss.length -1) = cdac (去头去尾)
 * 判断 [3] 中包含 [1] 则满足条件 
 */
repeatedSubstringPattern = function (s: string): boolean {
    let ss = s.repeat(2)
    return ss.substring(1, ss.length - 1).indexOf(s) != -1
}