package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] arr = new int[n];
       for (int i = 0; i < n; i++) {
           arr[i] = sc.nextInt();
       }

       int[] dp = new int[n + 1];
       dp[0] = 0;
       dp[1] = 1;
       for (int i = 2; i <= n; i++) {
           if (arr[0] == i) {
               dp[i] = 1;
               continue;
           }
           int min = Integer.MAX_VALUE;
           for (int j = 1; j < i; j++) {
               if (dp[j] + arr[j] >= i) {
                   min = Math.min(min, dp[j] + 2);
               }
           }
           dp[i] = Math.min(min, dp[i - 1] + 1);
       }
       System.out.println(Arrays.toString(dp));
       System.out.println(dp[n]);
   } 
}
