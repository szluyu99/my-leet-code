// https://leetcode.cn/problems/bitwise-xor-of-all-pairings/
// 暴力
class Solution1 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int res = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                res ^= (nums1[i] ^ nums2[j]);
            }
        }
        return res;
    }
}

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int res = 0;
        if (l2 % 2 == 1)
            for (int i = 0; i < l1; i++)
                res ^= nums1[i];
        if (l1 % 2 == 1)
            for (int i = 0; i < l2; i++)
                res ^= nums2[i];
        return res;
    }
}
