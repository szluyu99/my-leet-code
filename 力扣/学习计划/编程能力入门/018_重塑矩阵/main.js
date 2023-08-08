/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/submissions/
 * 566. 重塑矩阵
 * @param {number[][]} mat
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function (mat, r, c) {
    let m = mat.length, n = mat[0].length
    if (m * n != r * c) return mat

    let idx = 0, tmpArr = new Array(), res = []
    for (let i = 0; i < m; i++) {
        for (let j = 0; j <= n; j++) {
            if (idx == c) {
                res.push(tmpArr)
                tmpArr = []
                idx = 0
            }
            if (j == n) break
            tmpArr.push(mat[i][j])
            idx++
        }
    }
    return res
};