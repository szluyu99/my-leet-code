// https://www.acwing.com/problem/content/863/
#include <iostream>
#include <cstring>
using namespace std;
const int N = 510, M = 1e5 + 10;

// 稀疏图，使用邻接表存储
int h[N], e[M], ne[M], idx;
// st[j] = a 表示一轮模拟匹配中，女孩 j 被男孩 a 预定了
bool st[N];
// match[j] = a 表示女孩 j 现有配对男友是 a
int match[N];
// n1 n2 分别是两个点集的个数
int n1, n2, m;

void add(int a, int b)
{
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

// 如果 x 参与模拟配对，会不会使匹配数增多
bool find(int x)
{
    // 遍历 x 喜欢的女孩
    for (int i = h[x]; i != -1; i = ne[i])
    {
        int j = e[i]; // x 喜欢的女孩 j
        if (!st[j]) // 如果这轮匹配中，女孩 j 未被预定
        {
            st[j] = true; // x 预定女孩 j
            // 如果女孩 j 没有男朋友，或她原来的男朋友能够预定其他喜欢的女孩，则配对成功
            if (!match[j] || find(match[j]))
            {
                match[j] = x;
                return true;
            }
        }
    }
    // 自己喜欢的女孩全部被预定了，配对失败
    return false; 
}

int main()
{
    memset(h, -1, sizeof h);
    cin >> n1 >> n2 >> m;
    while (m--)
    {
        int a, b;
        cin >> a >> b;
        add(a, b); // 存边只存一条边即可，虽然是无向图
    }
    
    int res = 0;
    for (int i = 1; i <= n1; i++)
    {
        // 每次模拟匹配的预定情况都不一样，每轮都需要初始化
        memset(st, false, sizeof st);
        if (find(i)) res++;
    }
    cout << res << endl;
    return 0;
}