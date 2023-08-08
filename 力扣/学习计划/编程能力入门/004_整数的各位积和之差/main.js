/**
 * @param {number} n
 * @return {number}
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * 迭代
 */
var subtractProductAndSum = function (n) {
    let sum = 0, product = 1
    while (n) {
        let num = n % 10
        sum += num
        product *= num
        n /= 10
    }
    return product - sum
}

/**
 * @param {number} n
 * @return {number}
 * 转字符串转数组再迭代
 */
var subtractProductAndSum = function (n) {
    let nums = n.toString().split('').map(e => parseInt(e))
    let sum = 0, product = 1
    for (let num of nums) {
        sum += num
        product *= num
    }
    return product - sum
}