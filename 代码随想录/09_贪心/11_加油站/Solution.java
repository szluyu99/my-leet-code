// https://leetcode.cn/problems/gas-station/
// 贪心
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalNum = 0; // 总油量
        int curNum = 0; // 当前油量
        int start = 0; // 开始位置
        for (int i = 0; i < gas.length; i++) {
            curNum += gas[i] - cost[i];
            totalNum += gas[i] - cost[i];
            // 遇到油量不够的请求, 从下一站开始重新计算
            if (curNum < 0) {
                start = i + 1; // 更新起始位置为 i + 1
                curNum = 0;
            }
        } 
        return totalNum < 0 ? -1 : start;
    }
}