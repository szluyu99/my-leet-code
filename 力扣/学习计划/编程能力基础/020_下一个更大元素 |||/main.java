/**
 * https://leetcode-cn.com/problems/next-greater-element-iii/
 * 下一个更大元素 II
 */
class Solution {
    public int nextGreaterElement(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        int i = cs.length - 2;
        // 从后往前找到第一个逆序的数字 N
        while (i >= 0 && cs[i] >= cs[i + 1]) i--;
        if (i < 0) return -1;
        // 找到 N 后面比 N 大的 "最小数字"
        int j = cs.length - 1;
        while (j >= 0 && cs[j] <= cs[i]) j--;
        
        // 交换 N 和 比N大的"最小数字"的位置
        swap(cs, i, j); 
        // 将原来的 N 位置后面的数字变为最小序(本就是倒序,反转一下即可)
        reverse(cs, i + 1);

        // 转换成 int, 越界则返回 -1
        long res = 0;
        for (char c : cs) res = res * 10 + (c - '0');
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }

    void reverse(char[] cs, int start) {
        int i = start, j = cs.length - 1;
        while (i < j) swap(cs, i++, j--);
    }

    void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
