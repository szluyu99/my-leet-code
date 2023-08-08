/**
 * https://leetcode-cn.com/problems/verifying-an-alien-dictionary/ 
 * 验证外星词典
 */
let isAlienSorted = function (words: string[], order: string): boolean {
    let map = new Map()
    // 注：这样映射, 对应的数字越小, 字典序越大
    for (let i = 0; i < order.length; i++)
        map.set(order[i], i)
    // JS 中字符串取超出长度时为 undefined, 设置为最大字典序
    map.set(undefined, -1)
    // 单词之间两两比较
    for (let i = 0; i < words.length - 1; i++) {
        for (let j = 0; j < Math.max(words[i].length, words[i + 1].length); j++) {
            // 相同字母, 跳到下轮比较
            if (words[i][j] == words[i + 1][j]) continue
            // 前面的字母字典序中比较小(数字大), 则返回 false
            else if (map.get(words[i][j]) > map.get(words[i + 1][j]))
                return false;
            // 前面的字母字典序比较大, 进入 下两个单词的比较
            else break
        }
    }
    return true
};


isAlienSorted = function (words: string[], order: string): boolean {
    // 将每个单词的每个字母，替换成【order 中的索引对应的 ASCII 码】
    //（目的是防止索引较长出现多个字符，ASCII 码只对应一个字符）
    const newWords = words.map(word => {
        return word.split('').map(c => String.fromCharCode(order.indexOf(c))).join('')
    })
    // 浅拷贝后排序
    const sortedNewWords = [...newWords].sort()
    return equalArr(newWords, sortedNewWords);
}
// 比较两个数组的每个元素是否相同
const equalArr = (arrA, arrB) => arrA.every((x, i) => x === arrB[i])