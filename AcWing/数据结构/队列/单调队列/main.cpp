// https://www.acwing.com/problem/content/156/
#include <cstdio>
const int N = 1e6 + 10;
int a[N], q[N]; // 队列中存的是下标

int main()
{
    int n, k;
    scanf("%d %d", &n, &k);
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);

    int hh = 0, tt = -1; // 数组模拟队列
    // 单调递增队列
    for (int i = 0; i < n; i++)
    {
        // i - k + 1 滑动窗口头位置, q[hh] 窗口最小值的位置
        if (hh <= tt && i - k + 1 > q[hh]) hh++;
        while (hh <= tt && a[i] <= a[q[tt]] ) tt--;
        q[++tt] = i;
        if (i + 1 >= k) printf("%d ", a[q[hh]]);
    }
    puts("");

    hh = 0, tt = -1; // 重置队列
    // 单调递减队列
    for (int i = 0; i < n; i++)
    {
        if (hh <= tt && i - k + 1 > q[hh]) hh++;
        while (hh <= tt && a[i] >= a[q[tt]]) tt--;
        q[++tt] = i;
        if (i + 1 >= k) printf("%d ", a[q[hh]]);
    }

    return 0;
}