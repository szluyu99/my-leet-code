/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
const floodFill = function (image, sr, sc, newColor) {
    dfs(image, sr, sc, newColor, image[sr][sc])
    return image
};

const dfs = (image, sr, sc, newColor, originColor) => {
    // 越界
    if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return
    // 不满足上色要求, 或已经上色过
    if (image[sr][sc] != originColor || image[sr][sc] == newColor) return;
    // 上色
    image[sr][sc] = newColor

    dfs(image, sr - 1, sc, newColor, originColor)
    dfs(image, sr, sc + 1, newColor, originColor)
    dfs(image, sr + 1, sc, newColor, originColor)
    dfs(image, sr, sc - 1, newColor, originColor)
}