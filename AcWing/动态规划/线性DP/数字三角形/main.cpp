#include <iostream>
#include <cstring>
using namespace std;
const int N = 510, INF = 1e9;

int n;
int a[N][N];
int dp[N][N]; // dp[i][j] 从起点到 (i, j) 路径的最大值

int main() {
    cin >> n;

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= i; j++)
            cin >> a[i][j];

    // 初始化 DP 数组的值为负无穷
    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= i + 1; j++)
            dp[i][j] = -INF;

    dp[1][1] = a[1][1]; // 初始状态
    for (int i = 2; i <= n; i++)
        for (int j = 1; j <= i; j++)
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + a[i][j];

    // 找出最后一行的最大值
    int res = -INF;
    for (int i = 1; i <= n; i++) res = max(res, dp[n][i]);
    cout << res << endl;

    return 0;
}