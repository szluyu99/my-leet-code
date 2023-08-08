// https://www.acwing.com/problem/content/description/838/
#include <iostream>
using namespace std;
const int N = 1e5 + 10;

// 存储每个节点的祖宗节点, 当 p[x] == x, 表示这个数就是祖宗节点
int p[N]; 

// 返回 x 的祖宗节点 + 路径压缩
int find(int x)
{
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
    // 不进行路径压缩会超时
    // while (p[x] != x) x = p[x];
    // return x;
}

// 将编号为 a 和 b 的两个数所在的集合合并
void merge(int a, int b)
{
	p[find(a)] = find(b);
}

// 编号 a 和 b 的两个数是否在同一个集合中
bool isSame(int a, int b)
{
	return find(a) == find(b);
}

int main()
{
    int n, m;
    cin >> n >> m;

    // 初始化并查集，每个点的父节点是自己
    for (int i = 1; i <= n; i++) p[i] = i;

    while (m --)
    {
        char op;
        int a, b;
        cin >> op >> a >> b;

        if (op == 'M') merge(a, b);
        else puts(isSame(a, b) ? "Yes" : "No");
    }

    return 0;
}