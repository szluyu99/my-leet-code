package 力扣.比赛.LCCUP22_战队赛;

import java.util.HashMap;
import java.util.Map;

// class Solution {
//     public int beautifulBouquet(int[] flowers, int cnt) {
//         int n = flowers.length;
//         // dp[i][j] 长度从 i->j 的区间满足条件的数量
//         int[][] dp = new int[n][n];
//         // count[i][j] 表示 dp[i][j] 满足条件的数字的最大和
//         int[][] count = new int[n][n];
//         for (int i = 0; i < n; i++) {
//             dp[i][i] = 1;
//             count[i][i] = flowers[i]; // 记录最大的数字
//         }
//         for (int i = 0; i < n; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (dp[i][j - 1] == 0)
//                     break; // 上一位没有满足条件
//                 if (flowers[j] == count[i][j - 1])
//                     count[i][j] = flowers[j];
//                 if (count[i][j] > cnt)
//                     break;
//                 dp[i][j] += dp[i][j - 1] + 1;
//             }
//         }

//         return dp[0][n - 1] % 1000000007;
//     }
// }

// class Solution {
//     public int beautifulBouquet(int[] f, int cnt) {
//         int n = f.length;
//         int res = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         int l = 0, r = 1;
//         map.put(f[0], 1);
//         // for (int l = 0, r = 0; r < n || l < r; r++) {
//         while (r < n) {
//             System.out.println(l + " " + r);
//             if (r < n - 1)
//                 map.put(f[r], map.getOrDefault(f[r], 0) + 1);
//             if (map.get(f[r]) <= cnt)
//                 res++;
//             else {
//                 // 收缩左边界
//                 while (map.get(f[r]) > cnt && l < r) {
//                     System.out.println(l + " " + r);
//                     l++;
//                     map.put(f[l], map.get(f[l]) - 1);
//                     // if (map.get(f[l]) == 0) map.remove(f[l]);
//                 }
//             }
//             if (r == n - 1) {
//                 while (l < r) {
//                     System.out.println(l + " " + r);
//                     if (map.get(f[r]) <= cnt)
//                         res++;
//                     else {
//                         map.put(f[l], map.get(f[l]) - 1);
//                     }
//                     l++;
//                 }
//             }
//             r++;
//         }
//         return res;
//     }
// }

class Solution {
    int maxFreKey = -1;

    public int beautifulBouquet(int[] f, int cnt) {

        int ans = 0;
        int len = f.length;


        for (int sz = 1; sz <= f.length; sz++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < sz; i++) {
                map.put(f[i], map.getOrDefault(f[i], 0) + 1);
                // 更新最大频率
                map.put(maxFreKey, Math.max(map.getOrDefault(maxFreKey, 0), map.get(f[i])));
            }

            if (isValid(map, cnt)) ans++;

            for (int i = sz; i < len; i++) {
                
                if (map.get(f[i - sz]) == map.get(maxFreKey)) map.put(maxFreKey, -1);

                map.put(f[i - sz], map.getOrDefault(f[i - sz], 0) - 1);

                if (map.get(f[i - sz]) == 0) map.remove(f[i - sz]);

                map.put(f[i], map.getOrDefault(f[i], 0) + 1);
                if (map.get(maxFreKey) != -1) map.put(maxFreKey, Math.max(map.get(maxFreKey), map.get(f[i])));
                if (isValid(map, cnt)) ans++;
            }
        }
        return ans% 1000000007;
    }

    boolean isValid(HashMap<Integer, Integer> map, int cnt) {
        if (map.get(maxFreKey) >= 0 && map.get(maxFreKey) <= cnt) return true;

        boolean ans = true;
        for (int key : map.keySet()) {
            if (map.get(key) > cnt) ans = false;
            map.put(maxFreKey, Math.max(map.get(maxFreKey), map.get(key)));
        }
        return ans;
//        return true;
    }


}