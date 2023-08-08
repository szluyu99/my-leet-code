class Solution {
    /**
     * 摩尔投票法
     * 混战中一换一, vote 为冠军队伍人数, 遇到自己人则 1, 遇到敌人则 -1
     * vote 为 0 则下一个来的人成为冠军团队
     */
    public int majorityElement(int[] nums) {

        // vote 冠军队伍人数, selectNum 冠军队伍代表的数字
        int vote = 0, selectNum = 0;
        // 所有人轮流上台, 其中有 自己人 也有 敌人
        for (int num : nums) {
            // 冠军队伍人数为 0, 此时没有冠军队伍, 则下一个上台的人成为冠军队伍
            if (vote == 0) selectNum = num;
            // 判断是敌是友, 来决定增加人数还是减少人数
            vote += (num == selectNum) ? 1 : -1;
        }
        // 返回最终的冠军队伍
        return selectNum;
    }
}