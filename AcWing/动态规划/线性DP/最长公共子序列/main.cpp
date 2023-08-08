#include <iostream>
using namespace std;
const int N = 1010;

int n, m;
char a[N], b[N]; 
int f[N][N]; // 由 a 前 i 个元素, b 前 j 个元素构成的最长子序列的长度

int main()
{
    cin >> n >> m;
    scanf("%s%s", a + 1, b + 1);

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            f[i][j] = max(f[i - 1][j], f[i][j - 1]);
            if (a[i] == b[j]) f[i][j] = max(f[i][j], f[i - 1][j - 1] + 1);
        }
    }

    cout << f[n][m] << endl;

    return 0;
}