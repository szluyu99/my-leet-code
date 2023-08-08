// https://www.acwing.com/problem/content/840/
#include <iostream>
using namespace std;
const int N = 1e5 + 10;

int h[N], siz;

// 从 u 往下调整，使得数组满足堆的性质
void down(int u)
{
    // t 存储三个节点中存在最小的下标，初始化为当前节点 u
    int t = u;
    if (u * 2 <= siz && h[u * 2] < h[t]) t = u * 2;
    if (u * 2 + 1 <= siz && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
    // t 进行了更新操作，则交换数组中的值并重新从当前 t 开始调整堆
    if (t != u)
    {
        swap(h[t], h[u]);
        down(t);
    }
}

int main()
{
    int n, m;
    cin >> n >> m;
    // 读入乱序元素
    for (int i = 1; i <= n; i++) cin >> h[i];

    siz = n; // 初始化 size，表示堆里有 n 个元素
    // down 会检查下面的所有点，所以要从下往上
    // 把堆初始化成小根堆，从二叉树的倒数第二行开始，把数字大的下沉
    for (int i = n / 2; i; i--) down(i); 

    while (m --) 
    {
        cout << h[1] << " ";
        h[1] = h[siz--]; // 将最后一个元素挪到堆顶（相当于删除了最值元素）
        down(1); // 从头节点开始重新排列一遍，确保头节点是最小的
    }

    return 0;
}