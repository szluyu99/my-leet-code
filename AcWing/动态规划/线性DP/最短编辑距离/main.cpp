#include <iostream>
using namespace std;
const int N = 1010;

int n, m;
char a[N], b[N];
int f[N][N]; // f[i][j] a 的前 i 个字母转换成 b 的前 j 个字母使用的最少操作数

int main()
{
    scanf("%d%s", &n, a + 1);
    scanf("%d%s", &m, b + 1);

    // 初始化 dp 数组
    // 只能使用增加操作
    for (int i = 0; i <= m; i++) f[0][i] = i;
    // 只能使用删除操作
    for (int i = 0; i <= n; i++) f[i][0] = i;

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
        {
            // 删除 或 新增 操作
            f[i][j] = min(f[i - 1][j], f[i][j - 1]) + 1;
            // 最后一个字符相等则不需要修改, 否则需要修改
            if (a[i] == b[j]) f[i][j] = min(f[i][j], f[i - 1][j - 1]);
            else f[i][j] = min(f[i][j], f[i - 1][j - 1] + 1);
        }

    cout << f[n][m] << endl;

    return 0;
}