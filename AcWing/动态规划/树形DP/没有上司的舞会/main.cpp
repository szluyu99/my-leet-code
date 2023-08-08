// https://www.acwing.com/problem/content/description/287/
#include<cstring>
#include <iostream>
using namespace std;
const int N = 6010;

int n;
int happy[N]; // 职工的高兴度
int h[N], e[N], ne[N], idx;
// f[u][0] 所有以 u 为根的子树中选择，并且不选 u 这个点的方案
// f[i][1] 所有以 u 为根的子树中选择，并且选 u 这个点的方案
int f[N][2];
bool has_father[N]; // 判断当前节点是否有父节点

void add(int a, int b)
{
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u)
{
    f[u][1] = happy[u]; // 选择当前 u 节点
    for (int i = h[u]; i != -1; i = ne[i]) { // 遍历树的子节点
        int j = e[i]; // 子节点
        dfs(j);
        // 不选 u, 子节点 选 或 不选
        f[u][0] += max(f[j][1], f[j][0]);
        // 选 u, 子节点 只能不选
        f[u][1] += f[j][0];
    }
}

int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> happy[i];
    memset(h, -1, sizeof h);

    // 建树
    for (int i = 1; i < n; i++)
    {
        int a, b;
        cin >> a >> b;
        has_father[a] = true;
        add(b, a);
    }


    int root = 1;
    while (has_father[root]) root++; // 寻找根节点

    dfs(root);
    // 不选根节点 或 选根节点
    cout << max(f[root][0], f[root][1]) << endl;

    return 0;
}