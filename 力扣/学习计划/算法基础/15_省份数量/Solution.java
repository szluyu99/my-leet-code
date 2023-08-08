import java.util.Deque;
import java.util.LinkedList;

import common.UnionFindArr;

// https://leetcode.cn/problems/number-of-provinces/
// DFS
class Solution {
    public int findCircleNum(int[][] g) {
        boolean[] visited = new boolean[g.length];
        int cnt = 0;
        // 遍历出发省份
        for (int i = 0; i < g.length; i++) {
            if (!visited[i]) {
                dfs(g, visited, i);
                cnt++;
            }
        }
        return cnt;
    }

    void dfs(int[][] g, boolean[] visited, int i) {
        // 遍历从出发省份可以到达的省份
        for (int j = 0; j < g.length; j++) {
            if (g[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(g, visited, j);
            }
        }
    }
}

// BFS
class Solution1 {
    public int findCircleNum(int[][] g) {
        boolean[] visited = new boolean[g.length];
        int cnt = 0;
        for (int i = 0; i < g.length; i++)
            if (!visited[i])
                cnt += bfs(g, visited, i);
        return cnt;
    }

    int bfs(int[][] g, boolean[] visited, int u) {
        Deque<Integer> q = new LinkedList<>();
        q.add(u);
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j = 0; j < g.length; j++) {
                if (g[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
        return 1;
    }
}

// 并查集
class Solution2 {
    public int findCircleNum(int[][] g) {
        UnionFindArr uf = new UnionFindArr(g.length + 1);
        for (int i = 0; i < g.length; i++) {
            uf.add(i);
            for (int j = 0; j < i; j++)
                if (g[i][j] == 1)
                    uf.merge(i, j);
        }

        return uf.getNumOfSets();
    }
}
