package 力扣.比赛.LCCUP22_战队赛;

class Solution {
    public int minNumBooths(String[] demand) {
        int[] map = new int[129];
        for (String s : demand) {
            int[] tmp = new int[129];
            for (char c : s.toCharArray()) {
                tmp[c]++;
                if (tmp[c] > map[c]) map[c] = tmp[c];
            }
        }
        int res = 0;
        for (int i = 0; i < 129; i++) res += map[i];
        return res;
    }
}
