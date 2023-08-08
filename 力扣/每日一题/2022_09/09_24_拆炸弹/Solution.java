// https://leetcode.cn/problems/defuse-the-bomb/comments/
class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];

        if (k > 0) {
            for (int i = 0; i < code.length; i++) 
                for (int j = 1; j <= k; j++) 
                    res[i] += code[(i + j) % code.length];
        } else if (k < 0) {
            for (int i = 0; i < code.length; i++) 
                for (int j = 1; j <= -k; j++) 
                    res[i] += code[(i - j + code.length) % code.length];
        }

        return res;
    }
}