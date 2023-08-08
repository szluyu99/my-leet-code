package 笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class guaiwu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 怪物数量
        int[] a = new int[n]; // 怪物血量
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        // 预处理群功伤害最高
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n - 2; i++) {
            int t0 = a[i], t1 = a[i + 1], t2 = a[i + 2];
            while (t0 >= 1 && t1 >= 2 && t2 >= 3) {
                t0 -= 1;
                t1 -= 2;
                t2 -= 3;
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        
        // 对 TreeSet 的 value 排序
        var list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        // 先计算群功
        int mp = 0;
        for (var item : list) {
            int i = item.getKey();
            while (item.getValue() != 0 && a[i] >= 1 && a[i + 1] >= 2 && a[i + 2] >= 3) {
                mp += 5;
                a[i] -= 1;
                a[i + 1] -= 2;
                a[i + 2] -= 3;
                item.setValue(item.getValue() - 1);
            }
        }

        // 再计算单体
        for (int i = 0; i < n; i++) {
            while (a[i] > 0) {
                mp++;
                a[i]--;
            }
        }

        System.out.println(mp);
    } 
}