import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/arithmetic-subarrays/
 * 等差子数组
 */
/**
 * 暴力模拟
 */
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++)
            res.add(isArithmetic(Arrays.copyOfRange(nums, l[i], r[i] + 1)));
        return res;
    }

    boolean isArithmetic(int[] arr) {
        if (arr.length <= 1) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff)
                return false;
        }
        return true;
    }
}