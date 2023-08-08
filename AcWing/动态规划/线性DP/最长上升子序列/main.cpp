#include <iostream>
using namespace std;
const int N = 1010;

int n;
int a[N];
int dp[N]; // f[i] 以 i 结尾的上升子序列的长度

int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];

    int res = 1;
    for (int i = 1; i <= n; i++)
    {
        dp[i] = 1; // 只有 a[i] 一个数
        for (int j = i - 1; j >= 1; j--)
            if (a[j] < a[i])
                dp[i] = max(dp[i], dp[j] + 1);
        res = max(res, dp[i]);
    }
    cout << res << endl;

    return 0;
}