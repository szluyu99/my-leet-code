#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef int intAray[4];
void print(intAray *data, int m, int n)
{
    for (int i = 0; i < m + n - 1; i++)
    {
        for (int row = 0; row <= i; row++)
        {
            int col = i - row;
            if (col < n && col >= 0 && row < m)
                cout << data[row][col] << " ";
        }
        cout << endl;
    }
}

int main()
{
    // int data[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    // print(data, 3, 3);
    int nums[3] = {3, 2, 1};
    int maxv = *max_element(nums, nums + 3);
    int minv = *min_element(nums, nums + 3);
    cout << maxv << " " << minv << endl;
    return 0;
}