package 笔试;
import java.util.Arrays;
import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] ls = new int[m];
        int[] rs = new int[m];

        for (int i = 0; i < m; i++) ls[i] = sc.nextInt();
        for (int i = 0; i < m; i++) rs[i] = sc.nextInt();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                if (i >= (ls[j]) && i <= rs[j]) tmp++;
                if (tmp == 2) {
                    count++;
                    break;
                }
            } 
        }

        System.out.println(count);
    }    
}
