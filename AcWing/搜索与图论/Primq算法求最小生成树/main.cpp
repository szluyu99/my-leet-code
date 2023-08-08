// https://www.acwing.com/problem/content/860/
#include <iostream>
#include <cstring>
using namespace std;
const int N = 510, INF = 0x3f3f3f3f;

int g[N][N]; // 稠密图
int dist[N]; // 节点到生成树的距离
bool st[N]; // 节点是否在生成树中
int n, m;

// 返回最小生成树中边权之和
int prim()
{
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0; // 从 1 号点开始生成
    
    int res = 0;
    // 每次循环选出一个点加入到生成树中
    for (int i = 0; i < n; i++)
    {
        // 找到集合外，距离集合最小的点
        int t = -1;
        for (int j = 1; j <= n; j++) // 遍历所有节点
            if (!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;
        // 当前图是不连通的，不存在生成树
        if (dist[t] == INF) return INF;
        res += dist[t]; // 先更新最小生成树的边权和，防止有自环
        // 利用 t 更新生成树外的点到生成树的距离
        for (int j = 1; j <= n; j++) 
            // t->j 距离小于原来的距离，则更新
            dist[j] = min(dist[j], g[t][j]);
        
    }
    return res;
}

int main()
{
    // 各个点之间的距离初始化成无穷
    memset(g, 0x3f, sizeof g);
    
    cin >> n >> m;
    while (m --)
    {
        int a, b, c;
        cin >> a >> b >> c;
        g[a][b] = g[b][a] = min(g[a][b], c); // 无向图，有重边
    }
    
    int t = prim(); // 求最小生成树

    if (t == INF) puts("impossible");
    else cout << t << endl;
    
    return 0;
}