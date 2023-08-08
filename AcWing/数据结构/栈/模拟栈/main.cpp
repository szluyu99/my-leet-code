// https://www.acwing.com/problem/content/830/
#include <iostream>

using namespace std;

const int N = 1e5 + 10;

// s - 数组模拟栈，t - 栈顶指针
int s[N], t = -1;

// 向栈顶插入一个数 x
void push(int x)
{
    s[++t] = x;
}

// 从栈顶弹出一个数
void pop()
{
    t--;
}

// 判断栈是否为空
bool empty() 
{
    return t < 0;
}

// 查询栈顶元素
int query()
{
    return s[t];
}

int main()
{
    int m;
    cin >> m;

    while (m--)
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