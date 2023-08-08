class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int p1 = a.length(), p2 = b.length();
        while (p1 >= 0 || p2 >= 0) {
            char ca = (--p1 >= 0) ? a.charAt(p1) : '0';
            char cb = (--p2 >= 0) ? b.charAt(p2) : '0';

            if (ca == '1' && cb == '1') {
                if (carry == 1) sb.insert(0, "1");
                else sb.insert(0, "0");
                carry = 1;
                continue;
            }

            if (ca == '0' && cb == '0') {
                if (carry == 1) sb.insert(0, "1");
                else sb.insert(0, "0");
                carry = 0;
                continue;
            }

            if (carry == 1) {
                sb.insert(0, "0");
                carry = 1;
            } else {
                sb.insert(0, "1");
                carry = 0;
            }
        }
        return sb.charAt(0) == '0' ? sb.substring(1).toString() : sb.toString();
    }
}