package CodeTop;

import java.util.Random;

// https://leetcode.cn/problems/shuffle-an-array/

// 洗牌算法
class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = nums.clone();
        // i 所在的元素和它之前的所有元素包括它自身的随机选一个进行交换 
        for(int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(ans, i, j);  // rdm.nextInt(x) 代表取区间[0,x)内随机一个整数   
        }
        return ans;
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}

class Solution1 {
    private int[] nums;
    private int[] randomNums;
    private Random random;

    public Solution1(int[] nums) {
        this.nums = nums;
        this.randomNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            randomNums[i] = nums[i];
        }
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        swap(randomNums, random.nextInt(nums.length), 0);
        return randomNums;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}