// https://leetcode.cn/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            // 将数组一分为二，其中一个一定有序, 另一个可能有序或部分有序
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[r]) { // 如果中间的数小于最右边的数，则右半段是有序的
                // 确保 target 在右半部分
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            } else { // 若中间数大于最右边数，则左半段是有序的
                // 确保 target 在左半部分
                if (nums[l] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }
}

// 递归
class Solution1 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    int binarySearch(int[] nums, int l, int r, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[r]) {
                if (nums[mid] < target && target <= nums[r]) 
                    return binarySearch(nums, mid + 1, r, target);
                else return binarySearch(nums, l, mid - 1, target);
            } else {
                if (nums[l] <= target && target < nums[mid]) 
                    return binarySearch(nums, l, mid - 1, target);
                else return binarySearch(nums, mid + 1, r, target);
            }
        }
        return -1;
    }
}