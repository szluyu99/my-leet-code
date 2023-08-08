// https://www.acwing.com/problem/content/145/
#include <iostream>
using namespace std;
const int N = 1e5 + 10, M = 31 * N;

int a[N];
int son[M][2], idx;

void insert(int x)
{
    int p = 0;
    // 从高往低，因为越左的值不同异或结果越大
    for (int i = 30; i >= 0; i--)
    {
        int u = x >> i & 1; // 取 x 二进制第 i 位的值
        if (!son[p][u]) son[p][u] = ++idx; // 该节点不存在则创建
        p = son[p][u];
    }
}

int query(int x)
{
    int p = 0, res = 0;
    for (int i = 30; i >= 0; i--)
    {
        int u = x >> i & 1;
        if (son[p][!u])
        {
            p = son[p][!u];
            res = res * 2 + !u;
        }
        else
        {
            p = son[p][u];
            res = res * 2 + u;
        }
    }
    return res;
}

int main()
{
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];

    int res = 0;
    for (int i = 0; i < n; i++)
    {
        insert(a[i]);
        int t = query(a[i]);
        res = max(res, a[i] ^ t);
    }
    cout << res << endl;
    return 0;
}