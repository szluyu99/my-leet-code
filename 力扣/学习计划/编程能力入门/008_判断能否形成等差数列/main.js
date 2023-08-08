/**
 * https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
 * 判断能否形成等差数列
 * @param {number[]} arr
 * @return {boolean}
 * 迭代
 */
var canMakeArithmeticProgression = function (arr) {
    // js 负数排序, 需要传入函数, 否则是字符串排序
    arr = arr.sort((a, b) => a - b)
    let step = arr[1] - arr[0] // 根据前两个数算出步长 
    for (let i = 1; i < arr.length; i++)
        if (arr[i] != arr[i - 1] + step)
            return false;
    return true;
};

var canMakeArithmeticProgression = function (arr) {
    arr = arr.sort((a, b) => a - b)
    for (let i = 1; i < arr.length - 1; i++)
        return false;
    return true;
};