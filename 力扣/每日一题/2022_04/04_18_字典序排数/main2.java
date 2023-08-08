// DFS 先序遍历 10 叉树
class Solution {
    List<Integer> list = new ArrayList<>();
    int n;

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        for (int i = 1; i <= 9; i++) dfs(i);
        return list;
    }
    
    void dfs(int k) {
        if (k > n) return;
        list.add(k);
        if (k * 10 > n) return; // 剪枝
        for (int i = 0; i <= 9; i++) dfs(k * 10 + i);
    }
}