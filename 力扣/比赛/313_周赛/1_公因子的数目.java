// https://leetcode.cn/problems/number-of-common-factors/
class Solution {
    public int commonFactors(int a, int b) {
        int res = 0;
        for (int i = 1; i <= Math.max(a, b); i++)
            if (a % i == 0 && b % i == 0)
                res++;
        return res;
    }
}