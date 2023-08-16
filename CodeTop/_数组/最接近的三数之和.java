package CodeTop._数组;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (Math.abs(result - target) >= Math.abs(sum - target)) {
                    result = sum; 
                }
                if (sum < target) l++;
                else if (sum > target) r--;
                else return target;
            }
        }
        return result;
    }
}