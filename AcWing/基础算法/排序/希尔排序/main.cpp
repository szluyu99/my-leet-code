#include <iostream>
using namespace std;
const int N = 1e5 + 10;

int a[N];
int n;

void shell_sort()
{
    // 将待排序序列分隔成若干子序列
    for (int step = n / 2; step; step /= 2)
    {
        // 插入排序（对列进行）
        for (int i = step; i < n; i++)
        {
            int j = i;
            while (j >= step && a[j - step] > a[j])
                swap(a[j - step], a[j]), j -= step;
        }
    }
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    shell_sort();
    for (int i = 0; i < n; i++) cout << a[i] << " ";
}