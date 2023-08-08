#include <iostream>
#include <cstring>
using namespace std;
const int N = 110;
typedef pair<int, int> PII;
const int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

int g[N][N], d[N][N];
int n, m;

int bfs()
{
    PII q[N * N]; // 注意这里开辟的数组大小
    int hh = 0, tt = 0;
    q[tt++] = {0, 0};
    
    while (hh < tt)
    {
        PII t = q[hh++];
        for (int i = 0; i < 4; i++)
        {
            int x = t.first + dx[i];
            int y = t.second + dy[i];
            if (x >= 0 && x < n && y >= 0 && y < m && d[x][y] == -1 && g[x][y] == 0)
            {
                d[x][y] = d[t.first][t.second] + 1;
                q[tt++] = {x, y};
            }
        }
    }
    return d[n - 1][m - 1]; 
}

int main()
{
    memset(d, -1, sizeof d);
    d[0][0] = 0; 
    
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> g[i][j];
    cout << bfs() << endl; 
    return 0;
}