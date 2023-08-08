package 语言特性;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Test {
    public static void main(String args[]) {
        List<Integer> res = new ArrayList<>();
        int[] a = new int[5];
        res.add(a[0] = 1);
        System.out.println(a[0]);
        System.out.println(res.get(0));

        int[][] arr2 = new int[5][2];
        Arrays.sort(arr2, (n1, n2) -> n1[0] - n2[0]);

        // Scanner sc = new Scanner(System.in);
        // BigInteger i = sc.nextBigInteger();
        // BigInteger i2 = new BigInteger("999999999999999999999999999999999");
        // System.out.println(i.multiply(i2));

        // System.out.println(changeLetter('c'));
        // System.out.println(changeLetter('C'));

        // 大根堆
        // PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        // pq.offer(1);
        // pq.offer(2);
        // pq.offer(3);
        // pq.offer(4);
        // while (!pq.isEmpty()) {
        //     int t = pq.poll();
        //     System.out.println(t);
        // }
    }

    static char changeLetter(char c) {
        return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
    }
}