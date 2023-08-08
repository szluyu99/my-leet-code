// https://www.acwing.com/problem/content/902/
#include <iostream>
using namespace std;
const int N = 1010, M = 1e9 + 7;

int n;
int dp[N]; // dp[i] 表示放满容量为 i 的背包的方案数

int main()
{
    cin >> n;
    dp[0] = 1;
    for (int i = 1; i <= n; i++) // 物品
        for (int j = i; j <= n; j++) // 背包
            dp[j] = (dp[j] + dp[j - i]) % M;
            
    cout << dp[n] << endl;
 
    return 0;
}