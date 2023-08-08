/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
class Solution {
    /**
     * 首尾双指针遍历一次，开辟新数组，奇数从前放，偶数从后放
     * 时间：O(n)
     * 空间：O(n)
     */
    public int[] exchange(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        // p1 - 偶数位置，p2 - 奇数位置
        int p1 = 0, p2 = size - 1;
        for (int i = 0; i < size; i++) {
            if ((nums[i] & 1) != 0) // 奇数
                res[p1++] = nums[i];
            else // 偶数
                res[p2--] = nums[i];
        }
        return res;
    }
    /**
     * 首尾双指针遍历一次，找到奇偶数后交换位置
     * 时间：O(n)
     * 空间：O(1)
     */
    public int[] exchange1(int[] nums) {
        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2) {
            // 从前往后找奇数
            while (p1 < p2 && (nums[p1] & 1) == 1) p1++;
            // 从后往前找偶数
            while (p1 < p2 && (nums[p2] & 1) == 0) p2--;
            // 前后都找到就交换
            int tmp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = tmp;
        }
        return nums;
    }
    /**
     * 快慢双指针
     * 时间：O(n)
     * 空间：O(1)
     */
    public int[] exchange2(int[] nums) {
        int low = 0, fast = 0;
        while (fast < nums.length) {
            // fast遇到奇数则和slow交换
            if ((nums[fast] & 1) == 1) {
                int tmp = nums[fast];
                nums[fast] = nums[low];
                nums[low] = tmp;
                low++;
            }
            fast++;
        }
        return nums;
    }
}