import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/partition-labels/
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        
        int[] idx = new int[128]; // 记录每个小写字母最后出现的位置
        for (int i = 0; i < s.length(); i++) idx[s.charAt(i)] = i;

        int start = 0, end = 0; // 当前区间的开始与结束位置
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, idx[s.charAt(i)]); // 更新当前区间的能到的最远距离
            if (end == i) { // 到达当前区间能到的最远距离, 算是找到一个划分
                res.add(end - start + 1);
                start = end + 1; // 当前区间变为一个新的区间
            }
        }
        return res;
    }
}