package _数组;

class Solution {
    int[] h = new int[50010];
    int size = 0;

    void down(int u) {
        int t = u;
        if (u*2 <= size && h[u*2] < h[t]) t = u*2;
        if (u*2+1 <= size && h[u*2+1] < h[t]) t = u*2+1;
        if (t != u) {
            int tmp = h[u];
            h[u] = h[t];
            h[t] = tmp;
            
            down(t);
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        size = n;
        for (int i = 0; i < n; i++) {
            h[i + 1] = nums[i];
        }
        for (int i = n / 2; i > 0; i --) {
            down(i);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = h[1];
            h[1] = h[size--];
            down(1);
        }
        return result;
    }
}