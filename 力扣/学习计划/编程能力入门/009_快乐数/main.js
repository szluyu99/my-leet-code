/**
 * https://leetcode-cn.com/problems/happy-number/
 * 快乐数
 * @param {number} n
 * @return {boolean}
 * 模拟(map)
 */
var isHappy = function (n) {
    let newVal = 0, set = new Set()
    while (newVal != 1) {
        newVal = 0
        while (n) {
            newVal += Math.pow(~~(n % 10), 2)
            n /= 10
        }
        if (set.has(newVal)) return false;
        set.add(newVal)
        n = newVal
    }
    return true
};

/**
 *  模拟(map) 优雅写法
 */
var isHappy = function (n) {
    let set = new Set()
    while (n != 1) {
        n = bitSquareSum(n)
        if (set.has(n)) return false;
        set.add(n)
    }
    return true
};

/**
 * 快慢指针
 */
var isHappy = function (n) {
    let slow = n, fast = n
    do {
        slow = bitSquareSum(slow);
        fast = bitSquareSum(fast);
        fast = bitSquareSum(fast);
    } while (slow != fast)

    return slow == 1
};

/**
 * 求每位平方和
 */
var bitSquareSum = function (n) {
    let sum = 0
    while (n) {
        sum += ~~(n % 10) * ~~(n % 10)
        n /= 10
    }
    return sum
}