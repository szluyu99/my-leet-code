package AcWing.数据结构.栈.单调栈;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 使用栈数据结构
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (!stack.isEmpty() && stack.peek() >= x) stack.pop();
            if (!stack.isEmpty()) System.out.print(stack.peek() + " ");
            else System.out.print(-1 + " ");
            stack.push(x);
        }
    }

    // 数组模拟栈
    void arrayStack() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 数组模拟栈
        int[] stk = new int[n];
        int tt = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (tt > 0 && stk[tt] >= x) tt--;
            if (tt > 0) System.out.print(stk[tt] + " ");
            else System.out.print(-1 + " ");
            stk[++tt] = x;
        }
    }
}
