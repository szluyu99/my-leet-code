// https://www.acwing.com/problem/content/846/
#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
const int N = 110;
typedef pair<int, int> PII;

int g[N][N], d[N][N]; // g 地图, d 距离
PII Prev[N][N]; // 记录前驱，用于输出路径
int n, m; // n x m 的矩阵

void bfs() 
{
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1}; // 方向向量

    queue<PII> q;
    q.push({0, 0});

    memset(d, -1, sizeof d); // 初始化距离为 -1
    d[0][0] = 0; // 起点为 0

    while (!q.empty())
    {
        PII p = q.front();
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int x = p.first + dx[i], y = p.second + dy[i];
            if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1)
            {
                d[x][y] = d[p.first][p.second] + 1; // 更新距离
                q.push({x, y}); // 新坐标入队
                Prev[x][y] = p; // 更新前驱
            }
        }
    }

    // 输出路径
    int x = n - 1, y = m - 1;
    while (x || y) {
        cout << x << " " << y << endl;
        // Prev[x][y] 存储的是能到达当前位置的位置
        PII p = Prev[x][y];
        x = p.first, y = p.second;
    }

    cout << d[n - 1][m - 1] << endl;
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> g[i][j];
    bfs();
    return 0;
}
