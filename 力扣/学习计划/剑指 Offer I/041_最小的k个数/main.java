import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
class Solution {
    /**
     * 调用 API
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}