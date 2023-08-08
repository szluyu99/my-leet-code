class Solution {
    /**
     * 迭代 + StringBuilder
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == ' ') sb.append("%20");
        //     else sb.append(s.charAt(i));
        // }
        return sb.toString();
    }

    /**
     * 题解：字符数组
     */
    public String replaceSpace2(String s) {
        int n = s.length();
        char[] newArr = new char[3 * n]; // 最坏情况
        int j = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                newArr[j++] = '%';
                newArr[j++] = '2';
                newArr[j++] = '0';
            } else {
                newArr[j++] = c;
            }
        }              
        return new String(newArr, 0, j);
    }

    public static void main(String[] args) {
        String res = new Solution().replaceSpace("hello world!");
        System.out.println(res);
    }
}
