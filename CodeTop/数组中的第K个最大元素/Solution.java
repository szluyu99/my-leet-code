package CodeTop.数组中的第K个最大元素;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        final int N = 10010;
        int[] bucket = new int[N * 2]; // 处理负数
        for (int i = 0; i < nums.length; i++) bucket[nums[i] + N]++;
            
        int[] tmp = new int[nums.length];
        int t = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            while (bucket[i] != 0) {
                tmp[t++] = i - N; // 处理负数
                bucket[i]--;
            }
        }
        return tmp[k - 1];
    }
}