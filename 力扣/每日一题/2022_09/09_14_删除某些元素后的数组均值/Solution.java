import java.util.Arrays;

// https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/submissions/
class Solution {
    public double trimMean(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        double sum = 0;
        for (int i = len / 20; i < len * 19 / 20; i++)
            sum += arr[i];
        return sum / (len * 9 / 10);
    }
}