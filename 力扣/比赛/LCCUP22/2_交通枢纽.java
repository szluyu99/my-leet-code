import java.util.HashSet;
import java.util.Set;

class Solution {
    final int N = 10100;
    int in[] = new int[N]; // 入度
    int out[] = new int[N]; // 出度

    public int transportationHub(int[][] path) {
        Set<Integer> set = new HashSet<>();

        for (int[] p : path) {
            out[p[0]]++; // 出度
            in[p[1]]++; // 入度
            set.add(p[0]);
            set.add(p[1]);
        }

        int n = set.size();
        // 满足条件的点, 入度一定是 n - 1, 出度是 0
        for (int i = 0; i < 1010; i++)
            if (out[i] == 0 && in[i] == n - 1) return i;

        return -1;
    }
}