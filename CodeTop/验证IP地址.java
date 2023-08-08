package CodeTop;

// https://leetcode.cn/problems/validate-ip-address/
class Solution {
    public String validIPAddress(String queryIP) {
        queryIP = queryIP.toLowerCase();
        if (queryIP.contains(".")) {
            if (queryIP.contains(":")) return "Neither";

            // 加 -1 是防止出现空字符串无法计数 
            // 比如 192.168.1.1. 后边多了一个点, 不加 -1 会被忽略后边的空串
            String[] ss = queryIP.split("\\.", -1);
            if (ss.length != 4) return "Neither";
            
            for (String s : ss) {
                if (!isValidIPv4Part(s)) return "Neither";
            }
            return "IPv4";
        } else if (queryIP.contains(":")) {
            if (queryIP.contains(".")) return "Neither";

            String[] ss = queryIP.split(":", -1);
            if (ss.length != 8) return "Neither";
            
            for (String s : ss) {
                if (!isValidIPv6Part(s)) return "Neither";
            }
            return "IPv6" ;
        }

        return "Neither";
    }

    boolean isValidIPv4Part(String part) {
        if (part.length() < 1 || part.length() > 3) return false;
        if (part.startsWith("0") && !part.equals("0")) return false;
        for (char c : part.toCharArray()) {
            if (c < '0' || c > '9') return false;
        }
        int n = Integer.parseInt(part);
        return n >= 0 && n <= 255;
    }

    boolean isValidIPv6Part(String part) {
        if (part.length() < 1 || part.length() > 4) return false;
        if (part.equals("0")) return true;
        for (char c : part.toCharArray()) {
            if (!Character.isDigit(c) && c >= 'g') return false;
        }
        return true;
    }
}