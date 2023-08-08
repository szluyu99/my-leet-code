#include <iostream>
#include <unordered_map>
#include <stack>

stack<int> stk;
using namespace std;

int main()
{
    unordered_map<char, int> h{
        {'+', 1},
        {'-', 1},
        {'*', 2},
        {'/', 2},
    };

    cout << h['+'] << h['*'] << h['a'] << endl;

    return 0;
}