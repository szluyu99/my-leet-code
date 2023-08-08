package 笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class chuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String[] ss = new String[q];
        for (int i = 0; i < q; i++) ss[i] = sc.next();
        for (String s : ss) {
            System.out.println(help(s.toCharArray()) ? "YES" : "No");
        }
    }

    public static boolean help(char[] cs) {
        Set<String> set = new HashSet<>();

        return false;
    }


}
