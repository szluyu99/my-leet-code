// https://www.acwing.com/problem/content/901/
#include <iostream>
#include <cstring>
using namespace std;
const int N = 1010;

int n, m;
char str[N][N]; // 存储给定的 n 个字符串
int f[N][N]; // a[0..i] 转化到 b[0..j] 的最少操作次数

int minDistance(char a[], char b[])
{
    int la = strlen(a + 1), lb = strlen(b + 1);
    for (int i = 0; i <= la; i++) f[i][0] = i;
    for (int i = 0; i <= lb; i++) f[0][i] = i;
    
    for (int i = 1; i <= la; i++)
        for (int j = 1; j <= lb; j++)
        {
            if (a[i] == b[j]) f[i][j] = f[i - 1][j - 1];
            else f[i][j] = min(min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
        }

    return f[la][lb];
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> (str[i] + 1);

    while (m--) {
        int res = 0;
        char s[N];
        int limit;
        cin >> (s + 1) >> limit;
        for (int i = 0; i < n; i++)
            if (minDistance(str[i], s) <= limit) res++;
        cout << res << endl;
    }

    return 0;
}