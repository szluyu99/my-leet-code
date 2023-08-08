#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
const int N = 1e5 + 10;

int a[N];
int n;

// 快速排序
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

// 归并排序
int tmp[N];
void merge_sort(int l, int r)
{
    if (l >= r) return;
    int mid = l + r >> 1;
    merge_sort(l, mid);
    merge_sort(mid + 1, r);
    // 归并
    int i = l, j = mid + 1, k = 0;
    while (i <= mid && j <= r)
        tmp[k++] = (a[i] < a[j]) ? a[i++] : a[j++];
    while (i <= mid) tmp[k++] = a[i++];
    while (j <= r) tmp[k++] = a[j++];
    for (i = l, j = 0; i <= r; i++, j++) a[i] = tmp[j]; 
}

// 堆排序 - 手写
int h[N], siz;
void down(int u)
{
    int t = u;
    if (u * 2 <= siz && h[u * 2] < h[t]) t = u * 2;
    if (u * 2 + 1 <= siz && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
    if (u != t)
    {
        swap(h[u], h[t]);
        down(t);
    }
}
void heap_sort()
{
    // 堆数组下标从 1 开始
    for (int i = 1; i <= n; i++) h[i] = a[i - 1];
    // 建堆
    siz = n;
    for (int i = n / 2; i; i--) down(i);
    // 进行排序
    for (int i = 0; i < n; i++)
    {
        a[i] = h[1];
        h[1] = h[siz--];
        down(1);
    }
}

// 堆排序 (STL)
void heap_sort_stl()
{
    priority_queue<int, vector<int>, greater<int>> h;
    for (int i = 0; i < n; i++) h.push(a[i]);
    for (int i = 0; i < n; i++) 
    {
        a[i] = h.top();
        h.pop();
    }
}

// 冒泡排序
void bubble_sort()
{
    for (int i = n - 1; i > 0; i--)
        for (int j = 0; j < i; j++)
            if (a[j] > a[j + 1]) 
                swap(a[j], a[j + 1]);
}

// 选择排序
void select_sort()
{
    for (int i = 0; i < n; i++)
    {
        int min = i;
        for (int j = i + 1; j < n; j++)
            if (a[min] > a[j]) min = j;
        swap(a[i], a[min]);
    }
}

// 插入排序
void insert_sort()
{
    for (int i = 1; i < n; i++)
    {
        int j = i;
        while (j > 0 && a[j - 1] > a[j])
            swap(a[j - 1], a[j]), j--;
    }
}

// 希尔排序
void shell_sort()
{
    // 将待排序序列分隔成若干子序列
    for (int step = n / 2; step > 0; step /= 2)
    {
        // 插入排序
        for (int i = step; i < n; i++)
        {
            int j = i;
            while (j >= step && a[j - step] > a[j])
                swap(a[j], a[j - step]), j -= step;
        }
    }
}

// 计数排序
void counting_sort()
{
    // 找出序列中的最大值
    int max = a[0];
    for (int i = 1; i < n; i++) if (a[i] > max) max = a[i];  
    // 开辟最大值 + 1 的数组，并赋 0
    int count[max + 1] = {0};
    // 统计整数出现的次数
    for (int i = 0; i < n; i++) count[a[i]] ++;
    // 根据整数出现的次数，对整数进行排序
    int k = 0;
    for (int i = 0; i <= max; i++)
        while (count[i]--) a[k++] = i;
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    // sort(a, a + n); // api
    // quick_sort(0, n - 1);
    // merge_sort(0, n - 1);
    // bubble_sort();
    // select_sort();
    // insert_sort();
    // heap_sort();
    // heap_sort_stl();
    // shell_sort();
    // counting_sort();
    for (int i = 0; i < n; i++) cout << a[i] << " ";
    return 0;
}