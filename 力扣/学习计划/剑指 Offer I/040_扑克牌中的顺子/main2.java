import java.util.Arrays;

class Solution {
    /**
     * 排序 + 遍历
     */
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            // 统计大小数量
            if (nums[i] == 0)
                joker++;
            // 若有重复，提前返回 false
            else if (nums[i] == nums[i++])
                return false;
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nnums[joker] < 5;
    }
}