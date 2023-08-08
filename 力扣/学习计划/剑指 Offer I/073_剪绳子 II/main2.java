class Solution {
    public int cuttingRope(int n) {
        // 处理特殊情况
        if (n < 4) return n - 1;
        long res = 1;
        // 尽量将结果分成 3 更多的情况, 剩下是 2
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        } 
        return (int)(res * n % 1000000007);
    }
}