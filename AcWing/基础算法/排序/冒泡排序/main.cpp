#include <iostream>
using namespace std;
const int N = 1e5 + 10;

int a[N];
int n;

void bubble_sort()
{
    for (int i = n - 1; i > 0; i--)
        for (int j = 0; j < i; j++)
            if (a[j] > a[j + 1])
                swap(a[j], a[j + 1]);
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    bubble_sort();
    for (int i = 0; i < n; i++) cout << a[i] << " ";
    return 0;
}