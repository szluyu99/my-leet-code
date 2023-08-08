#include <iostream>
using namespace std;
const int N = 1e5 + 10;

// hh - 队头位置, tt - 队尾位置
int q[N], hh = 0, tt = -1;

// 向队尾插入一个 x
void push (int x)
{
    q[++tt] = x;
}

// 从队头弹出一个数
void pop ()
{
    hh++;
}

// 判断队列是否为空
bool empty() 
{
    return hh > tt;
}

// 查询队头元素
int query()
{
    return q[hh];
}

int main()
{
    int m;
    cin >> m;
    while (m --) 
    {
        int x;
        string op;
        cin >> op;
        if (op == "push")
        {
            cin >> x;
            push(x);
        }
        else if (op == "pop")
        {
            pop();
        }
        else if (op == "empty")
        {
            cout << (empty() ? "YES" : "NO") << endl;
        }
        else if (op == "query")
        {
            cout << query() << endl;
        }
    }
    return 0;
}