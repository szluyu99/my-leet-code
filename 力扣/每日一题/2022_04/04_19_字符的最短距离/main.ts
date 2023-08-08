/**
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * 821. 字符的最短距离
 */

// 暴力模拟
let shortestToChar = function (s: string, c: string): number[] {
    let arr = new Array()
    // 将 c 在 s 中的位置存起来 
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) == c) arr.push(i)
    }
    let res = new Array()
    for (let i = 0; i < s.length; i++) {
        // 遍历每个 c 在 s 中的位置, 寻找最近的位置
        let min = 10001
        arr.forEach(v => min = Math.min(min, Math.abs(v - i)))
        res.push(min)
    }
    return res
}

// 优化成两轮循环
shortestToChar = function (s: string, c: string): number[] {
    let res = new Array(s.length).fill(s.length + 1)
    // 从左往右, 找每个元素左边最近的 c
    for (let i = 0, j = -1; i < s.length; i++) {
        if (s.charAt(i) == c) j = i
        if (j != -1) res[i] = i - j
    }
    // 从右往左, 找每个元素右边最近的 c
    for (let i = s.length - 1, j = -1; i >= 0; i--) {
        if (s.charAt(i) == c) j = i
        if (j != -1) res[i] = Math.min(res[i], j - i)
    }
    return res
};