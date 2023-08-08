/**
 * 位运算
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int tmp = 0;
        // 求出两个只出现1次的数的 异或值
        for (int num : nums)
            tmp ^= num;

        // 保留最右的一个 1, 根据此进行分组
        // int group = tmp & (-tmp); // 简单写法
        int group = 1;
        while ((group & tmp) == 0)
            group <<= 1;

        // 分组计算
        int[] res = new int[2];
        for (int num : nums) {
            // 分组位为0的组
            if ((num & group) == 0)
                res[0] ^= num;
            // 分组位为1的组
            else
                res[1] ^= num;
        }
        return res;
    }
}