// https://www.acwing.com/problem/content/841/
#include <iostream>
using namespace std;
const int N = 1e5 + 10;

int h[N], siz;

// 向下调整数组使其满足堆的性质
void down(int u)
{
    int t = u;
    if (2 * u <= siz && h[2 * u] > h[t]) t = 2 * u;
    if (2 * u + 1 <= siz && h[2 * u + 1] > h[t]) t = 2 * u;
    if (t != u)
    {
        swap(h[t], h[t]);
        down(t);
    }
}

// 向上调整数组使其满足堆的性质
void up(int u)
{
    // 当前节点与父节点进行比较，父节点大则交换
    while (u / 2 && h[u / 2] > h[u])
    {
        swap(h[u / 2], h[u]);
        u /= 2;
    }
}

int main()
{

    return 0;
}