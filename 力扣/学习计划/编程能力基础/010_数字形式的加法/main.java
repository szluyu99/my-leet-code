import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * 数组形式的整数加法
 */
class Solution {
    /**
    * 模拟：数字转数字数组后进行操作
    */
    public List<Integer> addToArrayForm(int[] num, int k) {
        String[] ss = String.valueOf(k).split("");
        // string[] => int[]
        int[] is = Arrays.stream(ss).mapToInt(Integer::valueOf).toArray();
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int p1 = num.length - 1, p2 = is.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            int n1 = p1 >= 0 ? num[p1--] : 0;
            int n2 = p2 >= 0 ? is[p2--] : 0;
            int sum = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) >= 10 ? 1 : 0;
            res.add(0, sum);
        }
        if (carry == 1) res.add(0, 1);
        return res;
    }
}