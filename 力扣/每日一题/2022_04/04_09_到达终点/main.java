/**
 * https://leetcode-cn.com/problems/reaching-points/comments/
 * 780. 到达终点
 */
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > 0 && ty > 0){ // 因为sx, sy, tx, ty 是范围在 [1, 10^9] 的整数，逆推不能出界
            if (sx == tx && sy == ty) return true; // 判断是否到达了起始值
            // 每次逆推只能有tx、ty中较大值减去若干个较小值
            if (tx > ty) tx -= ty;
            else ty -= tx;
        }
        return false;
    }

    public boolean reachingPoints1(int sx, int sy, int tx, int ty) {
        while (tx > 0 && ty > 0){ // 因为sx, sy, tx, ty 是范围在 [1, 10^9] 的整数，逆推不能出界
            if (sx == tx && sy == ty) return true; // 判断是否到达了起始值
            // 此时只能有tx减去ty
            // tx - sx是目标与起始值在x的差距，我们需要一次减去n * ty达到快速逼近sx的目的
            if (tx > ty) tx -= Math.max((tx - sx) / ty, 1) * ty;
            // 此时只能有ty减去tx
            // ty - sy是目标与起始值在y的差距，我们需要一次减去n * tx达到快速逼近sy的目的
            else ty -= Math.max((ty - sy) / tx, 1) * tx;
        }
        return false;
    }
}