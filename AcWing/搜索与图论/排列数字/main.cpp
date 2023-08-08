// https://www.acwing.com/problem/content/844/
#include <iostream>
using namespace std;
const int N = 10;

int path[N]; // 路径
bool vis[N]; // 是否访问过
int n;

void dfs(int u)
{
    if (u == n)
    {
        for (int i = 0; i < n; i++) cout << path[i] << " ";
        puts("");
        return;
    }
    for (int i = 1; i <= n; i++)
    {
        if (!vis[i])
        {
            // 标记已访问，并添加到路径
            path[u] = i;
            vis[i] = true;
            // 继续搜索
            dfs(u + 1);
            // 回溯
            vis[i] = false;
        }
    }
}

int main()
{
    cin >> n;
    dfs(0); 
    return 0;
}
