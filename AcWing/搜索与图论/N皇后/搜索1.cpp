#include <iostream>
using namespace std;
const int N = 20;

int n;
// 存储路径
char g[N][N];
// bool 数组用来判断搜索的下一个位置是否可行
// col 列, dg 对角线(左上->右下), udg 反对角线(左下->右上)
bool col[N], dg[N], udg[N];

// 按行搜索，根据题意提取出每行一个皇后，u 表示当前搜索的行
void dfs(int u)
{
    if (u == n)
    {
        for (int i = 0; i < n; i++) puts(g[i]);
        puts("");
        return;
    }
    // 枚举 u 这一行，搜索合法的列
    int x = u;
    for (int y = 0; y < n; y++)
    {
        // 剪枝(对于不满足要求的点，不再继续往下搜索)  
        if (!col[y] && !dg[y - x + n] && !udg[y + x]) 
        {
            // 标记已访问，并加入路径
            col[y] = dg[y - x + n] = udg[y + x] = true;
            g[u][y] = 'Q';
            dfs(u + 1); // 递归下一层
            // 回溯
            g[u][y] = '.';
            col[y] = dg[y - x + n] = udg[y + x] = false;  
        }
    }
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            g[i][j] = '.';
    dfs(0);
    return 0;
}