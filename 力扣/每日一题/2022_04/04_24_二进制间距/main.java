/**
 * https://leetcode-cn.com/problems/binary-gap/
 * 二进制间距
 */
class Solution {
    // 转字符串, 一轮遍历
    public int binaryGap(int n) {
        String binStr = Integer.toBinaryString(n);
        int lastOneIdx = n, max = 0;
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1') {
                max = Math.max(max, i - lastOneIdx);
                lastOneIdx = i;
            }
        }
        return max;
    }

    // 位运算
    public int binaryGap1(int n) {
        int idx = 0, preIdx = n, max = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                preIdx = idx;
                max = Math.max(max, idx - preIdx);
            }
            idx++;
            n >>= 1;
        }
        return max;
    }
}