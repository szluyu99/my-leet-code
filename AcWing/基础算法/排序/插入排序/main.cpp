#include <iostream>
using namespace std;
const int N = 1e5 + 10;
int a[N], n;

void insert_sort()
{
    for (int i = 1; i < n; i++)
    {
        int x = i;
        while (x > 0 && a[x] < a[x - 1])
            swap(a[x], a[x - 1]), x--;
    }
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    insert_sort();
    for (int i = 0; i < n; i++) cout << a[i] << " ";
}