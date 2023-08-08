/**
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 * 所有奇数长度子数组的和
 * @param {number[]} arr
 * @return {number}
 * 暴力 3 轮循环
 */
var sumOddLengthSubarrays = function (arr) {
    let sum = 0
    for (let i = 1; i <= arr.length; i += 2) { // 奇数范围
        for (let j = 0; j < arr.length; j++) { // 每次从头开始算
            for (let k = j; k < j + i; k++) { // 每次走的步长
                if (j + i - 1 >= arr.length) break
                sum += arr[k]
            }
        }
    }
    return sum
};

// 暴力
// [1,4,2,5,3]
// 1, 14, 142, 14253
// 4, 425
// 2, 253
// 5
// 3
var sumOddLengthSubarrays = function (arr) {
    let sum = 0;
    const n = arr.length;
    for (let start = 0; start < n; start++) {
        for (let length = 1; start + length <= n; length += 2) { // 奇数
            const end = start + length - 1;
            for (let i = start; i <= end; i++)
                sum += arr[i];
        }
    }
    return sum;
};


/**
 * 前缀和
 * 利用前缀和，可以快速的计算出两个下标之间的所有元素的和
 */
var sumOddLengthSubarrays = function (arr) {
    const n = arr.length;
    const prefixSums = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++)
        prefixSums[i + 1] = prefixSums[i] + arr[i];

    let sum = 0;
    for (let start = 0; start < n; start++) {
        for (let length = 1; start + length <= n; length += 2) {
            const end = start + length - 1;
            sum += prefixSums[end + 1] - prefixSums[start];
        }
    }
    return sum;
};