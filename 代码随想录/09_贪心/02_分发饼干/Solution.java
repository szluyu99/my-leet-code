import java.util.Arrays;

// https://leetcode.cn/problems/assign-cookies/
// 贪心 + 双指针
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]) { // 饼干能喂饱孩子
                res++;
                j++; // 下一个孩子
            }
        }
        return res;
    }
}

// 贪心 + 双指针, 优化代码
class Solution1 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0; i < s.length && res < g.length; i++) 
            if (g[res] <= s[i]) res++;
        return res;
    }
}

// 暴力: 优化满足胃口小的孩子
class Solution2 {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        // 从小饼干开始发
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[j] == -1)
                    continue; // 该孩子已经满足
                if (s[i] >= g[j]) {
                    g[j] = -1; // 标记该孩子满足
                    res++;
                    break; // 该饼干已经发掉, 去发下一个饼干
                }
            }
        }
        return res;
    }
}