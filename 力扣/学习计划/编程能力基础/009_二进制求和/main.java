/**
 * https://leetcode-cn.com/problems/add-binary/
 * 67. 二进制求和
 */
class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int carry = 0;
        int p1 = a.length(), p2 = b.length();
        while (p1 >= 0 || p2 >= 0) {
            p1--;
            p2--;
            char ca = (p1 >= 0) ? a.charAt(p1) : '0';
            char cb = (p2 >= 0) ? b.charAt(p2) : '0';

            if (ca == '1' && cb == '1') {
                if (carry == 1)
                    res = "1" + res;
                else
                    res = "0" + res;
                carry = 1;
                continue;
            }

            if (ca == '0' && cb == '0') {
                if (carry == 1)
                    res = "1" + res;
                else
                    res = "0" + res;
                carry = 0;
                continue;
            }

            if (carry == 1) {
                res = "0" + res;
                carry = 1;
            } else {
                res = "1" + res;
                carry = 0;
            }
        }
        // return carry == 1 ? "1" + res : res;
        return res.charAt(0) == '0' ? res.substring(1) : res;
    }
}