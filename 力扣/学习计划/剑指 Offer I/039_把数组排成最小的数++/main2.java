import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
 */
class Solution {
    /**
     * 系统API + 自定义排序
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    /**
     * Lambda 一行写法
     */
    public String minNumber2(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (a + b).compareTo(b + a))
                .reduce("", (a, b) -> a + b);
    }
}