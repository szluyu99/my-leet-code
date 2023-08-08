/**
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * 寻找比目标字母大的最小字母
 */
class Solution {
    /**
     * 模拟
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int min = 'z' + 1;
        for (char l : letters) {
            if (l > target)
                min = Math.min(min, l);
        }
        return min == ('z' + 1) ? letters[0] : (char) (min);
    }

    /**
     * 顺序遍历
     */
    public char nextGreatestLetter0(char[] letters, char target) {
        for (char l : letters)
            if (l > target) return l;
        return letters[0];
    }
    /**
     * 二分(找右边界)
     */
    public char nextGreatestLetter1(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (letters[mid] > target)
                right = mid - 1;
            else if (letters[mid] <= target)
                left = mid + 1;
        }
        return letters[left] > target ? letters[left] : letters[0];
    }
}