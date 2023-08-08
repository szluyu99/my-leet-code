package CodeTop;

// https://leetcode.cn/problems/implement-rand10-using-rand7/
/*
class Solution extends SolBase {
    public int rand10() {
        int val = 0;
        for (int i = 1; i <= 5; i++) {
            val += rand7();
        }
        return val % 10 + 1;
    }
}
*/

/*
class Solution extends SolBase {
    int r = 0;
    public int rand10() {
        r += rand7();
        r %= 10;
        return r + 1;
    }
}
*/