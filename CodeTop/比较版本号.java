package CodeTop;

// https://leetcode.cn/problems/compare-version-numbers/

// split
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");

        for (int i = 0; i < Math.max(vs1.length, vs2.length); i++) {
            int n1 = 0, n2 = 0;
            if (i < vs1.length) n1 = Integer.valueOf(vs1[i]);
            if (i < vs2.length) n2 = Integer.valueOf(vs2[i]);
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
        }

        return 0;
    }
}

// 双指针
class Solution1 {
    public int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        char[] cs1 = version1.toCharArray(), cs2 = version2.toCharArray();
        int i = 0, j = 0;

        while (i < m || j < n) {
            int n1 = 0, n2 = 0;
            while (i < m && cs1[i] != '.') {
                n1 = n1 * 10 + cs1[i] - '0';
                i++;
            }
            while (j < n && cs2[j] != '.') {
                n2 = n2 * 10 + cs2[j] - '0';
                j++;
            }
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
            i++;
            j++;
        }

        return 0;
    }
}