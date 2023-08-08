package AcWing.数据结构.并查集.合并集合;

import java.util.Scanner;

class Main {
    static int p[];
    
    // 返回 x 的祖宗节点
    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    
    static void merge(int a, int b) {
        p[find(a)] = find(b);     
    }
    
    static boolean isSame(int a, int b) {
        return find(a) == find(b);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        p = new int[n + 1];
        
        // 初始化并查集
        for (int i = 1; i <= n; i++) p[i] = i; 
        
        while (m -- > 0) {
            String op = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (op.equals("M")) merge(a, b);
            else if (op.equals("Q")) System.out.println(isSame(a, b) ? "Yes" : "No");
        }
    }
}
