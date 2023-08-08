package 笔试;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class gzsz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(); // 数组长度为 n
        long k = sc.nextLong(); // 数组最大值不超过 k
        long x = sc.nextLong(); // 数组所有数之和等于 x

        List<Long> list = new ArrayList<>();

        long sum = 0;
        for (long i = k; i >= 1; i--) {
            if (list.size() == n - 2) {
                for (long j = i; j >= 0; j--) {
                    if (list.size() == n) break;
                    for (long a = 1; a < j; a++) {
                        if (j + a == (x - sum)) {
                            list.add(j);
                            list.add(a);
                        }
                    }
                }
                break;
            } else {
                sum += i;
                list.add(i);
            }
        }

        Collections.sort(list);

        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1)
                    System.out.print(list.get(i));
                else
                    System.out.print(list.get(i) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

}

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// long n = sc.nextInt(); // 数组长度为 n
// long k = sc.nextLong(); // 数组最大值不超过 k
// long x = sc.nextLong(); // 数组所有数之和等于 x

// list = new ArrayList<>();

// int sum = 0;
// for (long i = k; i > 0; i--) {
// list.add(i); // 6

// back(n - 1, i - 1, x - i);

// if (list.size() == n) break;
// list.remove(Long.valueOf(i)); // 找不到, 回溯
// }

// System.out.println(list.toString());
// }

// // 找 n 个数, 最大值为 k, 目标和为 x
// static void back(long n, long k, long x) {
// if (x < 0) {
// list.remove(list.size() - 1);
// return;
// }
// if (n == 0 || k == 0 || k == 0) {
// return;
// }
// list.add(k);
// back(n - 1, k - 1, x - k);
// }