/**
 * https://leetcode-cn.com/problems/lemonade-change/
 * 柠檬水找零
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 20 根本不用关心
        int five = 0, ten = 0;
        for (int bill: bills) {
            // 5 不用找
            if (bill == 5) five++;
            // 10 必须找 5
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            // 20 从 10, 5 依次找, 凑不到 15 则无法找
            } else if (bill == 20) {
                int temp = 15;
                while (temp != 0) {
                    if (ten > 0 && temp >= 10) {
                        temp -= 10;
                        ten--;
                    } else if (five > 0) {
                        temp -= 5;
                        five--;
                    } else return false;
                }
            }
        }
        return true;
    }
}