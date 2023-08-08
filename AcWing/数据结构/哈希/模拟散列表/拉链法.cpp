// https://www.acwing.com/problem/content/842/
#include <iostream>
#include <cstring>
using namespace std;
const int N = 100003; // 质数

int h[N], e[N], ne[N], idx;

void insert (int x)
{
    // x % N + N 保证结果必为正数
    int k = (x % N + N) % N;
    e[idx] = x, ne[idx] = h[k], h[k] = idx++;
}

bool find (int x)
{
    int k = (x % N + N) % N;
    for (int i = h[k]; i != -1; i = ne[i])
        if (e[i] == x) return true;
    return false;
}

int main()
{
    int n; cin >> n;
    memset(h, -1, sizeof h);

    while (n --)
    {
        char op;
        int x;
        cin >> op >> x;
        if (op == 'I') insert(x);
        else puts(find(x) ? "Yes" : "No");
    }
    return 0;
}