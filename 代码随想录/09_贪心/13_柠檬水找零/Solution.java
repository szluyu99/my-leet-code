// https://leetcode.cn/problems/lemonade-change/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[5];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) money[5]++;
            else if (bills[i] == 10) {
                if (money[5] < 0) return false;
                money[10]++;
                money[5]--;
            } else if (bills[i] == 20) {
                if (money[5] > 0 && money[10] > 0) {
                    money[5]--;
                    money[10]--;
                } else if (money[5] >= 3) {
                    money[5] -= 3;
                } else return false;
            }
        }
        return true;
    }
}