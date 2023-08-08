// https://leetcode.cn/problems/binary-search/
// y总模板
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }  
        if (nums[l] == target) return l;
        return -1;
    } 
}

// Java 源码
class Solution1 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) r = mid - 1;
            else if (nums[mid] > target) l = mid + 1;
            else return mid;
        }
        return - 1;
    }
}