import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0;
        List<int[]> res = new ArrayList<>();
        while (left <= (target / 2)) {
            if (sum < target)
                // 右指针向右移动
                sum += right++;
            else if (sum > target)
                // 左指针向右移动
                sum -= left++;
            else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++)
                    arr[i - left] = i;
                res.add(arr);
                sum -= left;
                // 左边界向右移动
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}