#include <iostream>
#include <string.h>
using namespace std;
const int N = 200003, null = 0x3f3f3f3f;

int h[N];

// 寻找 x 存在的位置（已存在）或目标放置位置（不存在）
int find(int x)
{
    int k = (x % N + N) % N;
    while (h[k] != null && h[k] != x)
    {
        k++;
        if (k == N) k = 0;
    }
    return k;
}

int main()
{
    int n; cin >> n;
    memset(h, 0x3f, sizeof h);

    while (n --)
    {
        char op;
        int x;
        cin >> op >> x;

        int k = find(x);
        if (op == 'I') h[k] = x;
        else puts(h[k] != null ? "Yes" : "No");
    }
    return 0;
}