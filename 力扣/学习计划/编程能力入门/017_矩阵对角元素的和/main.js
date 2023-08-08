/**
 * https://leetcode-cn.com/problems/matrix-diagonal-sum/comments/
 * 1572. 矩阵对角线元素的和
 * @param {number[][]} mat
 * @return {number}
 */
var diagonalSum = function (mat) {
    let i = 0, j = 0, sum = 0, len = mat.length
    while (i < len && j < len) {
        sum += mat[i][j]
        mat[i++][j++] = -1
    }
    i = 0, j = len - 1
    while (i < len && j >= 0) {
        if (mat[i][j] != -1)
            sum += mat[i][j]
        i++
        j--
    }
    return sum
};

var diagonalSum = function (mat) {
    let len = mat.length, sum = 0
    for (let i = 0; i < len; i++)
        sum += mat[i][i] + mat[i][len - i - 1]
    return len & 1 ? sum - mat[~~(len / 2)][~~(len / 2)] : sum
};