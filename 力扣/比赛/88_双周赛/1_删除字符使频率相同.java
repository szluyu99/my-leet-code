// https://leetcode.cn/problems/remove-letter-to-equalize-frequency/
class Solution {
    public boolean equalFrequency(String word) {
        int[] map = new int[26];
        for (char c : word.toCharArray()) map[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            map[i]--;
            if (checkFrequency(map)) return true;
            map[i]++;
        }
        return false;
    }

    // 检查 a 中字母频率是否相同
    boolean checkFrequency(int[] a) {
        int pre = -1;
        for (int i = 0; i < 26; i++) {
            if (pre == -1 && a[i] != 0) pre = a[i];
            if (a[i] != 0 && a[i] != pre) return false;
        }
        return true;
    }
}