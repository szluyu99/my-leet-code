// https://www.acwing.com/problem/content/850/
#include <iostream>
#include <cstring>
using namespace std;
const int N = 1e5 + 10;

int h[N], e[N], ne[N], idx;
int q[N], hh = 0, tt = -1; // 队列
int d[N]; // 入度
int n, m;

void add(int a, int b)
{
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool topsort()
{
    // 将入度为 0 的点入队
    for (int i = 1; i <= n; i++)
        if (d[i] == 0) q[++tt] = i;
    // 不停的将入度为 0 的点指向的边删除，删除后入度为 0 则入队
    while (hh <= tt)
    {
        int t = q[hh++];
        for (int i = h[t]; i != -1; i = ne[i])
        {
            int j = e[i];
            d[j] --; // 删除 t->j 的边
            // 如果 j 的入度为 0 则入队
            if (d[j] == 0) q[++tt] = j;
        }
    }
    // n 个点的都入队则为拓扑图
    return tt == n - 1;
}

int main()
{
    memset(h, -1, sizeof h);

    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        add(a, b); // 加边 a -> b
        d[b]++; // 维护 b 入度
    }
    if (topsort())
    {
        for (int i = 0; i < n; i++) cout << q[i] << " ";
        puts("");
    } else puts("-1");
    return 0;
}
