// https://leetcode.cn/problems/check-array-formation-through-concatenation/
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int idx = 0, preIdx = -1;
        boolean[] used = new boolean[101];
        while (idx != preIdx) { // idx 没有变化，说明找不到后续元素了
            preIdx = idx; // 记录 idx 是否发生变化
            for (int i = 0; i < pieces.length; i++) {
                if (idx == arr.length) return true; // 剪枝
                if (used[i]) continue; // 已经用过该数组
                for (int j = 0; j < pieces[i].length; j++) {
                    if (arr[idx] == pieces[i][j]) {
                        used[i] = true;
                        idx++;
                    }
                }
            }
        }
        return idx == arr.length;
    }
}