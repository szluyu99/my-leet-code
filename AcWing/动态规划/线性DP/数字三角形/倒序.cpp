#include<bits/stdc++.h>
using namespace std;
const int N = 510;

int dp[N][N];
int n;

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= i; j++)
            cin >> dp[i][j];

    for (int i = n; i >= 1; i--)
        for (int j = i; j >= 1; j--)
            dp[i][j] = max(dp[i + 1][j], dp[i + 1][j + 1]) + dp[i][j];

    cout << dp[1][1] << endl;
    return 0;
}