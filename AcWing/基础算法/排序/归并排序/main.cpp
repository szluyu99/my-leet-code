// https://www.acwing.com/problem/content/789/
#include <iostream>
using namespace std;

const int N = 100010;
int a[N], tmp[N];

void merge_sort(int l, int r) {
    if (l >= r) return;
	// 分界点
    int mid = (l + r) >> 1;
	// 递归左右两部分
    merge_sort(l, mid);
    merge_sort(mid + 1, r);

	// 归并
    int k = 0, i = l, j = mid + 1;
    while (i <= mid && j <= r)
    {
        if (a[i] <= a[j]) tmp[k++] = a[i++];
        else tmp[k++] = a[j++];
    }
    while (i <= mid) tmp[k++] = a[i++];
    while (j <= r) tmp[k++] = a[j++];
    for (i = l, j = 0; i <= r; i++, j++) a[i] = tmp[j];
}

int main()
{
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    merge_sort(0, n - 1);
    for (int i = 0; i < n; i++) cout << a[i] << " ";
}