// https://www.acwing.com/problem/content/828/
#include <iostream>

using namespace std;

const int N = 100010;

// head - 头节点的下标
// e[i] - 节点 i 的值
// ne[i] - 节点 i 的下一个节点的下标
// idx - 存储当前已经用到了哪个点
int head, e[N], ne[N], idx;

// 初始化
void init()
{
    head = -1;
    idx = 0;
}

// 将 x 插到头结点
void add_to_head(int x)
{
    e[idx] = x, ne[idx] = head, head = idx++;
}

// 将 x 插到下标 k 的点后面
void add(int k, int x)
{
    e[idx] = x, ne[idx] = ne[k], ne[k] = idx++;
}

// 将下标是 k 的点后面的点删除
void remove(int k)
{
    ne[k] = ne[ne[k]];
}

int main()
{
    int m;
    cin >> m;

    init();

    while (m --)
    {
        int k, x;
        char op;
        cin >> op;

        if (op == 'H')
        {
            cin >> x;
            add_to_head(x);
        }
        else if (op == 'D')
        {
            cin >> k;
            if (!k) head = ne[head]; // 删除头节点
            remove(k - 1);
        }
        else
        {
            cin >> k >> x;
            add(k - 1, x);
        }
    }

    // 遍历输出
    for (int i = head; i != -1; i = ne[i]) cout << e[i] << " ";
    cout << endl;

    return 0;
}