package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class main2 {
   public static void main(String[] args) {
       int[] jump = new int[1010005];
       int[] dp = new int[1010005];

       Arrays.fill(dp, -1);

       Scanner sc = new Scanner(System.in);
       int n  = sc.nextInt();

       dp[0] = 0;
       for (int i = 0; i < n; i++) {
           jump[i] = sc.nextInt();
           if (dp[i] == -1) dp[i] = Integer.MAX_VALUE - 1000000;
           if (dp[i + jump[i]] == -1) dp[i + jump[i]] = Integer.MAX_VALUE - 1000000;
           if (i + jump[i] >= n - 1) dp[n - 1] = Math.min(dp[i] + 1, dp[n - 1]);
           dp[i + jump[i]] = Math.min(dp[i] + 1, dp[i + jump[i]]);
       }
       for (int i = n - 1; i >= 0; i--) {
           if (dp[i] == -1) dp[i] = Integer.MAX_VALUE - 1000000;
           if (i - jump[i] >= 0 && dp[i - jump[i]] == -1) dp[i - jump[i]] = Integer.MAX_VALUE - 1000000;           
           if (i - jump[i] >= 0) dp[i - jump[i]] = Math.min(dp[i - jump[i]], dp[i] + 1);
       }

       for (int i = 0; i < n; i++) {
           if (dp[i] == -1) dp[i] = Integer.MAX_VALUE - 1000000;
           if (dp[i - jump[i]] == -1) dp[i - jump[i]] = Integer.MAX_VALUE - 1000000;         
           if (i + jump[i] >= n - 1) dp[n - 1] = Math.min(dp[n - 1] , dp[i] + 1);
           dp[i + jump[i]] = Math.min(dp[i] + 1, dp[i + jump[i]]);
       }
       System.out.println(dp[n - 1]);

   } 
}
