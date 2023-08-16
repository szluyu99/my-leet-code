package CodeTop;

// https://leetcode.cn/problems/palindrome-number/
// 字符串方法
class Solution {
    public boolean isPalindrome(int x) {
        return isPalindromeStr(String.valueOf(x));
    }

    static boolean isPalindromeStr(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }    
        return true;
    }
}


// 不转换成字符串
class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int inverted = 0;
        int n = x;
        while (n > 0) {
            inverted = inverted * 10 + n % 10;
            n /= 10;
        }
        return x == inverted;
    }
}