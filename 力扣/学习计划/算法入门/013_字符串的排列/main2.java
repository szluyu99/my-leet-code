import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;

        int cnt1[] = new int[s1.length()], cnt2[] = new int[s2.length()];
        for (char c : s1.toCharArray()) 
            cnt1[c - 'a']++;
        for (int i = m; i < n; i++) 
            cnt2[s2.charAt(i) - 'a']++;
        if (Arrays.equals(cnt1, cnt2)) return true;        
        for (int i = m; i < n; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - m) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }
}