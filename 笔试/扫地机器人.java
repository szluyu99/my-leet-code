package 笔试;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        int[][] g = new int[n + 1][m + 1];
        int i = 1, j = 1, num = 1;
        int count = 0;
        g[i][j] = 1;
        for (char c : s.toCharArray()) {
            count++;
            if (c == 'W') i--;
            else if (c == 'A') j--;
            else if (c == 'S') i++;
            else if (c == 'D') j++;
            if (g[i][j] == 0) num++;
            g[i][j] = 1;
            if (num == m * n) break;
        }

        if (num < m * n) {
            System.out.println("No");
            System.out.println(m * n - num);
        } else {
            System.out.println("Yes");
            System.out.println(count);
        }

    }
}