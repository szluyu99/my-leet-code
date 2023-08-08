// https://www.acwing.com/problem/content/853/
#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
const int N = 1e5 + 10;

int h[N], w[N], e[N], ne[N], idx; // 邻接表存储
int dist[N]; // 距离源点的距离
bool st[N]; // 每个点是否在队列中
int n, m;

void add (int a, int b, int c)
{
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

// 求 1 号点到 n 号点的最短路距离
void spfa()
{
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0;
    
    queue<int> q;
    q.push(1);
    st[1] = true;
    
    while (q.size())
    {
        int t = q.front();
        q.pop();
        st[t] = false;
        
        for (int i = h[t]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (dist[j] > dist[t] + w[i])
            {
                dist[j] = dist[t] + w[i];
                if (!st[j])
                {
                    q.push(j);
                    st[j] = true;
                }
            }
        }
    }
    if (dist[n] == 0x3f3f3f3f) puts("impossible");
    else cout << dist[n] << endl;
}

int main()
{
    memset(h, -1, sizeof h);
    cin >> n >> m;
    while (m --)
    {
        int a, b, c;
        cin >> a >> b >> c;
        add (a, b, c);
    }
    spfa();
    return 0;
}