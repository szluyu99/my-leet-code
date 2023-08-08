// https://www.acwing.com/problem/content/848/
#include <iostream>
#include <cstring>
using namespace std;
const int N = 1e5 + 10, M = N + N;
// 无向图，所以是双向边
int h[N], e[M], ne[M], idx;
bool st[N]; // 标记是否已经访问
int n;

int ans = N; 

void add(int a, int b)
{
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

// 返回以 u 为根的子树大小
int dfs(int u)
{
    st[u] = true;
    
    // sum 当前子树大小，res 删除当前点后连通块的最大值
    int sum = 1, res = 0;
    for (int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if (!st[j])
        {
            int s = dfs(j); // 以 j 为根的子树大小
            sum += s;
            res = max(res, s);
        }
    }
    res = max(res, n - sum);
    ans = min(ans, res);
    return sum;
}

int main()
{
    memset(h, -1, sizeof h);
    
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int a, b;
        cin >> a >> b;
        add(a, b), add(b, a);
    }
    dfs(1);
    cout << ans << endl;
    return 0;
}