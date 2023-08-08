// https://leetcode.cn/problems/minimize-xor
class Solution {
    public int minimizeXor(int num1, int num2) {
        int n1 = getOneNum(num1), n2 = getOneNum(num2);
        if (n1 == n2) return num1;
        char[] cs = ("0".repeat(n2) + Integer.toBinaryString(num1)).toCharArray();
        if (n1 < n2) {
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == '1') n2--;
                if (n2 == 0) break;
            }
            for (int i = cs.length - 1; i >= 0; i--) {
                if (cs[i] == '0') {
                    cs[i] = '1';
                    n2--;
                }
                if (n2 == 0) break;
            }
        } else if (n1 > n2) {
            for (int i = 0; i < cs.length; i++) {
                if (n2> 0 && cs[i] == '1') n2--;
                else cs[i] = '0';
            }
        }
        return Integer.parseInt(String.valueOf(cs), 2);
    }


    public int getOneNum(int n) {
        long num = Integer.toUnsignedLong(n);
        int res = 0;
        while (num > 0) {
            if ((num & 1) == 1)
                res++;
            num >>= 1;
        }
        return res;
    }
}