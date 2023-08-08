#include <cstring>
#include <iostream>
#include <queue>
using namespace std;
const int N = 1e6 + 10;
typedef pair<int, int> PII; // 堆里存储 { 距离, 节点编号 }

int h[N], w[N], e[N], ne[N], idx; // 邻接表（稀疏图）
int dist[N]; // 距离源点的距离
bool st[N]; // 是否已经找到最短路
int n, m;

// 添加 a 指向 b 边长为 c 的边
void add(int a, int b, int c)
{
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx ++ ;
}

int dijkstra()
{
    memset(dist, 0x3f, sizeof dist); // 距离初始化为无穷大
    dist[1] = 0;
    
    priority_queue<PII, vector<PII>, greater<PII>> heap; // 小根堆
    heap.push({0, 1}); // 1 号点距离源点距离为 1

    while (heap.size())
    {
        PII t = heap.top(); // 距离源点最近的点
        heap.pop();

        int ver = t.second; // 距离源点最近的点
        int distance = t.first; // 源点距离 ver 的距离

        if (st[ver]) continue; // 如果距离已经确定，则跳过该点
        
        // 更新 ver 所指向的节点距离       
        st[ver] = true;
        for (int i = h[ver]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (dist[j] > dist[ver] + w[i])
            {
                dist[j] = dist[ver] + w[i];
                heap.push({dist[j], j}); // 距离变小，则入堆
            }
        }
    }

    if (dist[n] == 0x3f3f3f3f) return -1;
    return dist[n];
}

int main()
{
    memset(h, -1, sizeof h);

    cin >> n >> m;
    while (m -- )
    { 
        int a, b, c;
        cin >> a >> b >> c;
        add(a, b, c); // 邻接表不需要考虑重边
    }
    cout << dijkstra() << endl;
    return 0;
}