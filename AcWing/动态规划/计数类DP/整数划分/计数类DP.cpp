#include <iostream>
using namespace std;
const int N = 1010, M = (1e9 + 7);

int n;
int f[N][N]; // 总和为 i, 总个数为 j 的方案数

int main()
{
    cin >> n;
    f[1][1] = 1;
    for (int i = 2; i <= n; i++)
        for (int j = 1; j <= i; j++)
            f[i][j] = (f[i - 1][j - 1] + f[i - j][j]) % M;

    int res = 0;
    for (int i = 1; i <= n; i++) res = (res + f[n][i]) % M;
    cout << res << endl;

    return 0;
}