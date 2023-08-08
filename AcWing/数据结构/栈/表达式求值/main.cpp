// https://www.acwing.com/problem/content/3305/
#include <iostream>
#include <unordered_map>
#include <stack>
using namespace std;

stack<int> num;
stack<char> op;

// 优先级表
unordered_map<char, int> h{{'+', 1}, {'-', 1}, {'*', 2}, {'/', 2}};

// 求值
void eval()
{
    // 第一个操作数
    int a = num.top(); num.pop();
    // 第二个操作数
    int b = num.top(); num.pop();
    // 运算符
    char p = op.top(); op.pop();

    // 计算结果并入栈
    int res = 0;
    if (p == '+') res = b + a;
    if (p == '-') res = b - a;
    if (p == '*') res = b * a;
    if (p == '/') res = b / a;
    num.push(res);
}

int main()
{
    string exp;
    cin >> exp;

    for (int i = 0; i < exp.size(); i++)
    {
        // 扫描到数字
        if (isdigit(exp[i]))
        {
            int x = 0, j = i;
            while (j < exp.size() && isdigit(exp[j]))
            {
                x = x * 10 + exp[j] - '0';
                j++;
            }
            num.push(x);
            i = j - 1;
        }
        // '(' 直接入栈
        else if (exp[i] == '(')
        {
            op.push(exp[i]);
        }
        // ')' 计算内容直到遇到匹配的 '('
        else if (exp[i] == ')')
        {
            while (op.top() != '(') eval();
            op.pop(); // '(' 出栈
        }
        else
        {
            // 待入栈运算符优先级低（或相等）则先计算
            while (op.size() && h[op.top()] >= h[exp[i]]) eval();
            op.push(exp[i]);
        }
    }

    // 计算栈中剩余的
    while (op.size()) eval();

    cout << num.top() << endl;

    return 0;
}