package CodeTop;

// https://leetcode.cn/problems/course-schedule/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if (n == 0) return true;
        int[] val = new int[] { prerequisites[0][0], prerequisites[0][1] } ;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int[] tmp = prerequisites[j];
                if (tmp[0] == tmp[1]) return false;
                if (!visited[j] && val[1] == tmp[0]) {
                    val[1] = tmp[1];
                    visited[j] = true;
                }
                if (val[0] == val[1]) return false;
            }
        }
        if (n == 1) return true;

        for (int i = 0; i < n; i++) {
            int[] tmp = prerequisites[i]; 
            if (tmp[0] == val[0] && tmp[1] == val[1]) {
                return false;
            }
        }

        return true;
    }
}