#include <bits/stdc++.h>
using namespace std;

// https://leetcode.cn/problems/combination-sum-ii/comments/
class Solution {
public:
    vector<vector<int>> res;
    vector<int> candidates;
    int target;

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end()); // 为后面去重做准备
        this->candidates = candidates;
        this->target = target;
        vector<int> path;
        dfs(path, 0, 0); 
        return res;
    }

    void dfs(vector<int>& path, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
            res.push_back(path);
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            // 去重
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            sum += candidates[i];
            path.push_back(candidates[i]);
            dfs(path, sum, i + 1);
            sum -= candidates[i];
            path.pop_back();
        }
    }
};