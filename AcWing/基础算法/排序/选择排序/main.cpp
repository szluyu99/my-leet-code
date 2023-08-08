#include <iostream>
using namespace std;
const int N = 1e5 + 10;
int a[N], n;

void select_sort()
{
    for (int i = 0; i < n; i++)
    {
        int min = i;
        for (int j = i + 1; j < n; j++)
            if (a[j] < a[min]) min = j;
        swap(a[i], a[min]);
    }
}


void select_sort_2()
{
    for (int i = n - 1; i >= 0; i--)
    {
        int max = i;
        for (int j = i - 1; j >= 0; j--)
            if (a[j] > a[max]) max = j;
        swap(a[j], a[max]);
    }
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    select_sort();
    for (int i = 0; i < n; i++) cout << a[i] << " ";
}