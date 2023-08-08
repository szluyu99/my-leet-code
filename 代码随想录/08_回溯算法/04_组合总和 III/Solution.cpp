#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> res;
    vector<int> path;
    int n, k;
    vector<vector<int>> combinationSum3(int k, int n) {
        this->k = k;
        this->n = n;
        dfs(path, 0, 1); 
        return res;
    }

    void dfs(vector<int>& path, int sum, int u) {
        if (sum > n) return; // 剪枝
        if (sum == n && path.size() == k) {
            res.push_back(path);
            return;
        }
        for (int i = u; i <= 9; i++) {
            path.push_back(i);
            sum += i;
            dfs(path, sum, i + 1);
            path.pop_back();
            sum -= i;
        }
    }
};