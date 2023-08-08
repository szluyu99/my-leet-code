import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/design-hashmap/submissions/
 * 设计哈希映射
 */

/**
 * 数组
 */
class MyHashMap {

    int[] nums;

    public MyHashMap() {
        nums = new int[1000005];
        Arrays.fill(nums, -1);
    }

    public void put(int key, int value) {
        nums[key] = value;
    }

    public int get(int key) {
        return nums[key];
    }

    public void remove(int key) {
        nums[key] = -1;
    }
}