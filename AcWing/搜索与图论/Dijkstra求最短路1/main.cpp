// https://www.acwing.com/problem/content/851/
#include <iostream>
#include <cstring>
using namespace std;
const int N = 510;

int g[N][N]; // 邻接矩阵（稠密图）
int dist[N]; // 每个点距离起点的距离
bool st[N]; // 每个点的最短路是否已经确定
int n, m;

int dijkstra()
{
    // 距离初始化成无穷大
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0; // 1 号点距离为 0
    
    // 找到当前没有确定最短路的点中，距离最小的
    for (int i = 0; i < n; i++)
    {
        int t = -1;
        for (int j = 1; j <= n; j++)
            // 当前点未确定最短路 && 当前路不是最短的
            if (!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;
        st[t] = true; // 标记已经确定最短路
        // 使用 t 更新其他点距离
        for (int j = 1; j <= n; j++)
            // 比较 1--> j 和 1--> t --> j 的距离
            dist[j] = min(dist[j], dist[t] + g[t][j]);
    }
    
    if (dist[n] == 0x3f3f3f3f) return -1;
    return dist[n];
}

int main()
{
    // 默认边长初始化成无穷大
    memset(g, 0x3f, sizeof g); 
    
    cin >> n >> m;
    while (m --)
    {
        int a, b, c;
        cin >> a >> b >> c;
        // 处理重边，只需要记录最短的边
        g[a][b] = min(g[a][b], c); 
    }

    cout << dijkstra() << endl;
    return 0;
}