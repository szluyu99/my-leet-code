class Solution {
    /**
     * 题解：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/wei-shi-yao-ta-shi-yi-ge-pai-xu-wen-ti-b-hh21/
     * 冒泡排序
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                // 比如 34,3 -----> 343 > 334 所以两个数需要交换位置
                if ((strs[j] + strs[j + 1]).compareTo(strs[j + 1] + strs[j]) > 0) {
                    String tmp = strs[j + 1];
                    strs[j + 1] = strs[j];
                    strs[j] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++)
            sb.append(strs[i]);

        return sb.toString();
    }
}