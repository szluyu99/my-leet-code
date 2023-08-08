/**
 * 有效的字母异同位
 * https://leetcode-cn.com/problems/valid-anagram/
 * sort api
 */
let isAnagram = function (s: string, t: string): boolean {
    return [...s].sort().toString() == [...t].sort().toString()
};

/**
 * map
 */
isAnagram = function (s: string, t: string): boolean {
    let map = new Map<string, number>()
    // 将 s 中的字符与其出现次数做映射
    for (let c of s)
        map.set(c, (map.get(c) ?? 0) + 1)
    // 遍历 t 中的字符, map 中存在其映射则 -1
    for (let c of t)
        map.set(c, map.get(c) - 1)
    // 如果 map 中字符的映射次数还有 > 0 的, 说明不满足条件
    for (let val of map.values())
        if (val > 0) return false
    return true
};

/**
 * 数组
 */
isAnagram = function (s: string, t: string): boolean {
    let counts = new Array<number>(26).fill(0)
    for (let c of s)
        counts[c.charCodeAt(0) - 'a'.codePointAt(0)]++
    for (let c of t) 
        if (counts[c.charCodeAt(0) - 'a'.codePointAt(0)] == 0) return false
    for (let num of counts)
        if (num != 0) return false
    return true
}