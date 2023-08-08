// https://www.acwing.com/problem/content/849/
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
const int N = 1e5 + 10;

int e[N], ne[N], h[N], idx = 0;
int d[N]; // 存储每个节点离起点的距离 d[1] = 0
int n, m; // n 个点 m 条边
int q[N]; // 存储层次遍历序列

void add(int a, int b)
{
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int bfs() {
    memset(d, -1, sizeof d);
    d[1] = 0; // 存储每个节点离起点的距离
    
    int hh = 0, tt = 0;
    q[0] = 1; // 0 号节点是编号为 1 的节点
    while (hh <= tt)
    {
        int t = q[hh++]; // 队头元素
        // 遍历 t 节点的每个邻边
        for (int i = h[t]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (d[j] == -1)
            {
                d[j] = d[t] + 1; // 存储 j 节点距离起点的距离并标记已访问
                q[++tt] = j; // 入队
            }
        }
    }
    return d[n];
}

int main()
{
    memset(h, -1, sizeof h);

    // 读入数据并建图
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        add(a, b);
    }

    cout << bfs() << endl;

    return 0;
}