// https://leetcode.cn/problems/monotone-increasing-digits/
class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        // 从右往左扫描, 若当前数字比其左边一位小
        // 则把左边一位数字减1, 并将该位及其右边所有位改成9
        int start = cs.length; // 标记哪一位开始要变成9
        for (int i = cs.length - 1; i >= 1; i--) {
            if (cs[i] < cs[i - 1]) {
                cs[i - 1]--;
                start = i;
            }
        }
        for (int i = start; i < cs.length; i++) cs[i] = '9';
        return Integer.parseInt(new String(cs));
    }
}

// 模拟
class Solution1 {
    public int monotoneIncreasingDigits(int n) {
        int[] nums = numToArray(n);
        while (!isIncrement(n)) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 || nums[i - 1] > nums[i])  {
                    nums[i - 1]--;
                    for (int j = i; j < nums.length; j++) nums[j] = 9;
                    break;
                }
            }
            n = arrayToNum(nums);
        }
        return n;
    }

    // 判断数字是否单调递增
    boolean isIncrement(int n) {
        int pre = n % 10, last = n % 10;
        while (n != 0) {
            last = n % 10;
            if (last > pre) return false;
            n /= 10;
            pre = last;
        }
        return true;
    }

    // int -> int[]
    int[] numToArray(int num) {
        int n = 0;
        int tmp = num;
        while (tmp > 0) {
            tmp /= 10;
            n++;
        }
        int[] nums = new int[n];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
        }
        return nums;
    }

    // int[] -> int
    int arrayToNum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res = res * 10 + nums[i];
        return res;
    }
}