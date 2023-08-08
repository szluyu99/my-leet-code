/**
 * https://leetcode-cn.com/problems/combinations/
 * 77. 组合
 */
let res: number[][]
function combine(n: number, k: number): number[][] {
    res = new Array()
    dfs(n, k, 1, new Array())
    return res
};

const dfs = function (n: number, k: number, begin: number, path: number[]) {
    // 剪枝
    if (path.length + (n - begin + 1) < k) return;
    if (path.length == k) {
        res.push([...path]);
        return;
    }
    for (let i = begin; i <= n; i++) {
        path.push(i)
        dfs(n, k, i + 1, path);
        // 回溯
        path.pop()
    }
}