/**
 * https://leetcode-cn.com/problems/goal-parser-interpretation/comments/
 * 设计 Goal 解析器
 * @param {string} command
 * @return {string}
 */
var interpret = function (command) {
    return command.replaceAll('()', 'o').replaceAll('(al)', 'al')
};

/**
 * 暴力 + 分情况
 */
var interpret = function (command) {
    let res = []
    for (let i = 0; i < command.length; i++) {
        if (command[i] == 'G') res.push('G')
        if (command[i] == '(') {
            if (command[i + 1] == ')') {
                res.push('o')
                i++
            } else {
                res.push('al')
                i += 3
            }
        }
    }
    return res.join('')
};
