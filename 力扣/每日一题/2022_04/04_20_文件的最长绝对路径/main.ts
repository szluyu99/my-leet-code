/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 388. 文件的最长绝对路径
 */
 function lengthLongestPath(input: string): number {
    let res = 0
    let lengthCount = new Array(10005).fill(0)
    let path = input.split('\n')
    console.log(path)
    for (let i = 0; i < path.length; i++) {
        let count = countTabs(path[i]) // 统计 \t 的数量, 即 层级
        // 计算下一层的字符串长度
        // 一个 '\t' 占两个字符, 但是换成目录后, '\' 只占一个字符
        lengthCount[count + 1] = lengthCount[count] + path[i].length - count
        // 字符串中包含 "." 说明找到文件, 更新结果
        if (path[i].includes('.')) res = Math.max(res, lengthCount[count + 1] + count)
    }
    console.log(lengthCount)
    return res
};

// 统计字符串 s 中 '\t' 的数量
function countTabs(s: string) {
    let start = 0
    while (start < s.length && s.charAt(start) == '\t') start++
    return start
}