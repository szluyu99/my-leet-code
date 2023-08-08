#include <iostream>
#include <cstdio>
#include <string>

using namespace std;
typedef unsigned long long ULL;
const int N = 1e5 + 5;
// P = 131 或 13331 Q=2^64，在 99% 的情况下不会出现冲突
const int P = 131; // 131 13331 是经验值
// h[i] 字符串的哈希前缀和
ULL h[N], p[N];

// h[i] 前 i 个字符的 hash 值
// 字符串变成一个 P 进制数字，体现了字符 + 顺序，需要确保不同的字符串对应不同的数字
// 使用场景：两个字符串的子串是否相同
ULL query(int l, int r)
{
    return h[r] - h[l - 1] * p[r - l + 1];
}

int main()
{
    int n, m;
    cin >> n >> m;
    string x;
    cin >> x;

    p[0] = 1;
    h[0] = 0;
    // 前缀和
    for (int i = 0; i < n; i++)
    {
        p[i + 1] = p[i] * P; // 预处理 P 进制
        h[i + 1] = h[i] * P + x[i]; // 前缀和求整个字符串的哈希值
    }

    while (m--)
    {
        int l1, r1, l2, r2;
        cin >> l1 >> r1 >> l2 >> r2;
        puts((query(l1, r1) == query(l2, r2) ? "Yes" : "No"));
    }

    cout << p << endl;
    return 0;
}