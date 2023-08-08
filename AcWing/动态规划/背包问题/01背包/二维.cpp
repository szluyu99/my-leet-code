#include <iostream>
using namespace std;
const int N = 1010;

int n, m; // 物品数量, 背包容量
int v[N]; // 体积
int w[N]; // 价值
int f[N][N]; // f[i][j], 前 i 个物品中体积不超过 j 的最大价值

int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> v[i] >> w[i];

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
        {
            // 当前背包容量装不下第 i 个物品, 则价值等于前 i-1 个物品
            if (j < v[i]) f[i][j] = f[i - 1][j];
            // 当前背包容量能装下第 i 个物品, 选择是否装第 i 个物品
            else f[i][j] = max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]);
        }

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
            cout << f[i][j] << endl;

    cout << f[n][m] << endl;

    return 0;
}