class Solution {
    /**
     * 常规递归做法（不满足题意）
     */
    public int sumNums0(int n) {
        if (n == 1) return 1;
        return sumNums0(n - 1) + n;
    }
    
    /**
     * 短路效应实现递归出口
     */
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}