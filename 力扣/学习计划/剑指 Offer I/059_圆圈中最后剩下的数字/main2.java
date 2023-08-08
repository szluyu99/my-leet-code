/**
 * 数学法: 利用递推公式
 */
class Solution {
    public int lastRemaining(int n, int m) {
        if (n == 0) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    
}