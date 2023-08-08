// https://www.acwing.com/problem/content/787/
#include <iostream>
using namespace std;

const int N = 100010;
int a[N];

void quick_sort(int l, int r) {
    if (l >= r) return;
    int i = l - 1, j = r + 1, x = a[(l + r) >> 1];
    while (i < j) {
        do i++; while (a[i] < x);
        do j--; while (a[j] > x);
        if (i < j) swap(a[i], a[j]);
    }
    quick_sort(l, j);
    quick_sort(j + 1, r);
}

int main()
{
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    quick_sort(0, n - 1);
    for (int i = 0; i < n; i++) cout << a[i] << " ";
    return 0;
}
