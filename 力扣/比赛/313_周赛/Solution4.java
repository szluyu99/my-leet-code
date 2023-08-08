class Solution {
    public int deleteString(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length() / 2; j++) {
                if (s.substring(i, i + j).equals(s.substring(i + j, i + j * 2))) {
                    s = s.substring(i + j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}