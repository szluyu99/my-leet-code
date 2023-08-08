package CodeTop.验证回文串;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) 
            if (Character.isLetterOrDigit(c)) sb.append(c);
        return sb.toString().equals(sb.reverse().toString());  
    }
}