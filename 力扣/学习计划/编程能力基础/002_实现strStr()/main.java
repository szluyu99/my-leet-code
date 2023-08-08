class Solution {
    /**
     * 库函数
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 暴力模拟(超时)
     */
    public int strStr1(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        if (needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int tmpIdx = 0;
            while (i + tmpIdx < haystack.length()
                && haystack.charAt(i + tmpIdx) == needle.charAt(tmpIdx++)) 
                if (tmpIdx == needle.length()) return i;
        }
        return -1;
    }
    
    /**
     * 滑动窗口
     */
    public int strStr2(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        // 窗口长度
        int width = needle.length();
        // 当前索引
        int idx = 0;
        // 只访问不会越界的部分
        while (idx + width <= haystack.length()) {
            // 找到则返回索引
            if (needle.equals(haystack.substring(idx, idx + width)))
                return idx;
            idx++; 
        }
        return -1;
    }

}