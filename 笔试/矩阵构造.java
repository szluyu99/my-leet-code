package 笔试;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n][n];

        int k = 1;
        if (n % 2 == 1) { // 奇数长度，顺序排列即可
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    res[i][j] = k++;
        } else { // 偶数长度，交错排列
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++)
                        res[i][j] = k++;
                } else {
                    for (int j = n - 1; j >= 0; j--)
                        res[i][j] = k++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(res[i][j] + " ");
            System.out.println();
        }
    }
}