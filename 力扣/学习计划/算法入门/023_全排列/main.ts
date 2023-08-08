/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 */

let res: number[][]
function permute(nums: number[]): number[][] {
    res = new Array();
    let visited = new Array();
    dfs(nums, new Array(), visited)
    return res;
};

const dfs = function (nums: number[], path: number[], visited: boolean[]) {
    if (path.length == nums.length) {
        res.push([...path]);
        return;
    }
    for (let i = 0; i < nums.length; i++) {
        if (visited[i]) continue;
        // 标记已访问
        visited[i] = true;
        path.push(nums[i]);
        // 继续搜索
        dfs(nums, path, visited)
        // 回溯
        visited[i] = false;
        path.pop()
    }
}