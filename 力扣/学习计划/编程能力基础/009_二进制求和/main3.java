class Solution {
    /**
     * 模拟：优雅代码
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int c = 0; // 进位
        while (i >= 0 || j >= 0) {
            if (i >= 0) c += a.charAt(i--) - '0';
            if (j >= 0) c += b.charAt(j--) - '0';
            sb.append(c & 1);
            c >>= 1;
        }
        String res = sb.reverse().toString();
        return c > 0 ? "1" + res : res;
    }
}