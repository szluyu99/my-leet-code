/**
 * https://leetcode-cn.com/problems/construct-quad-tree/
 * 建立四叉树
 */
class Solution {
    int[][] grid;
    public Node construct(int[][] grid) {
        this.grid = grid;
        return dfs(0, 0, grid.length);
    }

    Node dfs(int x, int y, int m) {
        if (m == 1) return new Node(grid[x][y] == 1, true);
        Node topL = dfs(x, y, m / 2);
        Node topR = dfs(x, y + m / 2, m / 2);
        Node bottomL = dfs(x + m / 2, y, m / 2);
        Node bottomR = dfs(x + m / 2, y + m / 2, m / 2);
        if (topL.isLeaf && topR.isLeaf && bottomL.isLeaf && bottomR.isLeaf
            && topL.val == topR.val && topL.val == bottomL.val && topL.val == bottomR.val) {
            return new Node(topL.val, true);
        } else {
            return new Node(true, false, topL, topR, bottomL, bottomR);
        }
    }
}