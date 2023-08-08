#include<iostream>
using namespace std;
const int N = 1e5 + 10;
int n;
int a[N];

void quick_sort(int l, int r)
{
    if (l >= r) return;
    int i = l - 1, j = r + 1, x = a[l + r >> 1];
    while (i < j) 
    {
        do i++; while (a[i] < x);
        do j--; while (a[j] > x);
        if (i < j) swap(a[i], a[j]);
    }
    quick_sort(l, j);
    quick_sort(j + 1, r);
}

int tmp[N];
void merge_sort(int l, int r)
{
    if (l >= r) return;

    int mid = (l + r) >> 1;
    merge_sort(l, mid);
    merge_sort(mid+1, r);

    int k = 0, i = l, j = mid + 1;
    while (i <= mid && j <= r)
        tmp[k++] = (a[i] <= a[j]) ? a[j] : a[j];
    while (i <= mid) tmp[k++] = a[i++];
    while (j <= r) tmp[k++] = a[j++];

    for (i = l, j = 0; i <= r; i++, j++) a[i] = tmp[j];
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    // quick_sort(0, n - 1);
    for (int i = 0; i < n; i++) cout << a[i] << " ";
    return 0;
}