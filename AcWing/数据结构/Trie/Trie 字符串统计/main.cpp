// https://www.acwing.com/problem/content/description/837/
#include <iostream>
using namespace std;
const int N = 1e5 + 10;

// son[][] 存储当前节点的子节点的位置，分支最多 26 条
// cnt[] - 以当前点结尾的字符串个数（同时起标记作用）
// idx - 当前要插入的节点是第几个，每创建一个节点值 + 1
int son[N][26], cnt[N], idx;
char str[N];

void insert(char *str)
{
    int p = 0;
    for (int i = 0; str[i]; i++)
    {
        int u = str[i] - 'a'; // 字母 -> 数字
        // 该节点不存在，创建节点
        if (!son[p][u]) son[p][u] = ++idx;
        p = son[p][u];
    }
    cnt[p]++; // 结束时的标记，也是记录此节点结束的字符串个数
}

int query(char * str)
{
    int p = 0;
    for (int i = 0; str[i]; i++)
    {
        int u = str[i] - 'a';
        if (!son[p][u]) return 0; // 该节点不存在，即字符串不存在
        p = son[p][u];
    }
    return cnt[p]; // 返回字符串出现的次数
}

int main()
{
    int n; cin >> n;
    while (n --) 
    {
        char op[2];
        cin >> op >> str;
        if (*op == 'I') insert(str);
        else cout << query(str) << endl;
    }
    return 0;
}