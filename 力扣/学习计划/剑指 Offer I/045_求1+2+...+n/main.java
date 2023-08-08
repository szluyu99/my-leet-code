/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
class Solution {
    public int sumNums(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}