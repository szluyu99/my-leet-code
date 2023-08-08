/**
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 * 1672. 最富有客户的资产总量 
 * @param {number[][]} accounts
 * @return {number}
 */
var maximumWealth = function (accounts) {
    let max = -1
    for (let i = 0; i < accounts.length; i++) {
        let sum = 0
        for (let j = 0; j < accounts[0].length; j++)
            sum += accounts[i][j]
        max = Math.max(max, sum)
    }
    return max
};

var maximumWealth = function (accounts) {
    let max = -1
    for (let account of accounts)
        max = Math.max(max, account.reduce((pre, cur) => pre + cur), 0)
    return max
}