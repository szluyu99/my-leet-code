package CodeTop;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/
class Solution {
    List<String> result = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs("", 0, 0);
        return result;
    }

    void dfs(String path, int l, int r) {
        if (l > n || r > n) {
            return;
        }

        if (l == n && r == n) {
            result.add(path);
            return;
        }

        if (l >= r) {
            dfs(path + "(", l + 1, r);
            dfs(path + ")", l, r + 1);
        }
    }
}