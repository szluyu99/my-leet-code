#include <cstring>
#include <iostream>
using namespace std;
const int N = 310;

int n, m; // 网格行列
int f[N][N]; // 从 h[i][j] 位置开始滑的路径的最大值
int h[N][N];
// 方向向量: 左上右下
int dx[4] = { -1, 0, 1, 0 }, dy[4] = { 0, 1, 0, -1 };

int dp(int x, int y)
{
    int& v = f[x][y];
    if (v != 0) return v; // 已经计算过则直接返回答案
    v = 1;
    for (int i = 0; i < 4; i++)
    {
        // 下一个位置
        int xx = x + dx[i], yy = y + dy[i];
        // 必须在边界范围内
        if (xx >= 1 && xx <= n && yy >= 1 && yy <= m && h[xx][yy] < h[x][y])
            v = max(v, dp(xx, yy) + 1); // 更新
    }
    return v;
}

int main()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
            cin >> h[i][j];
    int res = 0;
    // 可以从任意点开始
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
            res = max(res, dp(i, j));
    cout << res << endl;
    return 0;
}