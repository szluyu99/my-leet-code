class Solution {
    /**
     * 位运算
     */
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (char c : t.toCharArray())
            res += c;
        for (char c : s.toCharArray())
            res -= c;
        return (char) res;
    }

    /**
     * 位运算一行
     */
    public char findTheDifference1(String s, String t) {
        return (char) (s + t).chars().reduce(0, (a, b) -> a ^ b);
    }

    /**
     * 字符和之差
     */
    public char findTheDifference2(String s, String t) {
        int res = 0;
        for (char c : t.toCharArray())
            res += c;
        for (char c : s.toCharArray())
            res -= c;
        return (char) res;
    }
}