import java.util.Arrays;

/**
 * 库函数
 */
class Solution {
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index < 0 ? -1 : index;
    }
}