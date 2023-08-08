// https://www.acwing.com/solution/content/5052/
#include <iostream>

using namespace std;

const int N = 1e5 + 10;

int e[N], l[N], r[N], idx;

// 初始化双链表
void init()
{
    // 0 表示左端点，1 表示右端点
    r[0] = 1, l[1] = 0;
    idx = 2;
}

// 在 k 下标的节点右边插入 x
void add(int k, int x)
{
    e[idx] = x;
    l[idx] = k;
    r[idx] = r[k];
    l[r[k]] = idx;
    r[k] = idx;
    idx++;
}

// 在 k 下标的节点左边插入 x
// add(l[k], x);

// 删除 k 下标的节点
void remove(int k)
{
    r[l[k]] = r[k];
    l[r[k]] = l[k];
}

int main()
{
    int m;
    cin >> m;

    init();

    while (m--)
    {
        int k, x;
        string op;
        cin >> op;

        if (op == "L")
        {
            cin >> x;
            add(0, x); // 0 左端点
        }
        else if (op == "R")
        {
            cin >> x;
            add(l[1], x); // 1 右端点
        }
        else if (op == "D")
        {
            cin >> k;
            remove(k + 1); // k - 1 + 2
        }
        else if (op == "IL")
        {
            cin >> k >> x;
            add(l[k + 1], x);
        }
        else if (op == "IR")
        {
            cin >> k >> x;
            add(k + 1, x);
        }
    }

    for (int i = r[0]; i != 1; i = r[i])
        cout << e[i] << ' ';

    return 0;
}