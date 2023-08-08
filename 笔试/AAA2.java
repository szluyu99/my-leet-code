package 笔试;

import java.util.Scanner;

public class AAA2 {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int h1 = sc.nextInt();
       int m1 = sc.nextInt();
       int h2 = sc.nextInt();
       int m2 = sc.nextInt();

       System.out.println((h2 * 60 + m2) - (h1 * 60 + m1));
   } 
}
