// https://www.acwing.com/problem/content/description/839/
#include <iostream>
using namespace std;
const int N = 1e5 + 10;

// p[i] i 的祖先节点
// nums[i] i 的连通块中点的数量
int p[N], nums[N];

// 查找 x 的祖宗节点 + 路径压缩
int find(int x)
{
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

int main()
{
    int n, m;
    cin >> n >> m;
  
    // 初始化并查集
    for (int i = 1; i <= n; i++)
    {
        p[i] = i;
        nums[i] = 1; // 默认只有一个点
    }

    while (m--)
    {
        int a, b;
        char op[2]; 
        cin >> op;
        if (op[0] == 'C')
        {
            cin >> a >> b;
            if (find(a) == find(b)) continue; // a b 已经在一个集合中
            nums[find(b)] += nums[find(a)];
            p[find(a)] = find(b); // 合并
        }
        else if (op[1] == '1')
        {
            cin >> a >> b;
            puts(find(a) == find(b) ? "Yes" : "No");
        }
        else if (op[1] == '2')
        {
            cin >> a;
            cout << nums[find(a)] << endl;
        }
    }
    return 0;
}