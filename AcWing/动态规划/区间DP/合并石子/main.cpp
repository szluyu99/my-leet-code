#include <iostream>
#include <cstring>
using namespace std;
const int N = 310;

int n;
int s[N]; // 前缀和
int f[N][N]; // f[i][j] 将第 i 堆石子和第 j 堆石子合并的代价的最小值

int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> s[i];

    // 处理前缀和
    for (int i = 1; i <= n; i++) s[i] += s[i - 1];

    for (int len = 2; len <= n; len++) // 第一维: 区间长度
    {
        for (int l = 1; l + len - 1 <= n; l++) // 第二维: 区间起始点
        {
            int r = l + len - 1; // 区间终点
            f[l][r] = 0x3f3f3f;
            for (int k = l; k < r; k++) // 决策: 枚举分割点
                f[l][r] = min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
        }
    }

    cout << f[1][n] << endl;

    return 0;
}