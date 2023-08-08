class Solution {
    /**
     * 位运算
     */
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];

        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < 32; j++)
                // 整数i先被右移 31 - 
                arr[j] += nums[i] >> (31 - j) & 1;

        return 0;
    }
}