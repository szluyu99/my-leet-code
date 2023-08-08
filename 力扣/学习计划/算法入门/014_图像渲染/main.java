/**
 * DFS
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    /**
     * @param image       二维数组
     * @param sr          当前行
     * @param sc          当前列
     * @param newColor    新颜色
     * @param originColor 旧颜色
     */
    void dfs(int[][] image, int sr, int sc, int newColor, int originColor) {
        // 越界, 停止遍历
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        // 不满足上色要求, 或是已经上色过, 停止遍历
        if (image[sr][sc] != originColor || image[sr][sc] == newColor) return;

        // 上色
        image[sr][sc] = newColor;

        dfs(image, sr - 1, sc, newColor, originColor);
        dfs(image, sr, sc + 1, newColor, originColor);
        dfs(image, sr + 1, sc, newColor, originColor);
        dfs(image, sr, sc - 1, newColor, originColor);
    }
}