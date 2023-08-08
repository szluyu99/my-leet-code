#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int n, k;
    vector<vector<int>> res;
    vector<int> path;
    vector<vector<int>> combine(int n, int k) {
        this->n = n;
        this->k = k;
        dfs(path, 1);
        return res;
    }

    void dfs(vector<int> path, int u) {
        if (k == path.size()) {
            res.push_back(path);
            return;
        }
        // 剪枝操作
        for (int i = u; i <= n - (k - path.size()) + 1; i++) {
            path.push_back(i);
            dfs(path, i + 1);
            path.pop_back();
        }
    }
};