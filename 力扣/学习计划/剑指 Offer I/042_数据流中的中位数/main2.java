import java.util.Arrays;

class MedianFinder {

    int[] arr;
    int size = 0;
    int medium = 0;

    public MedianFinder() {
        arr = new int[50000];
    }

    public void addNum(int num) {
        arr[size++] = num;
    }

    public double findMedian() {
        Arrays.sort(arr, 0, size);
        if ((size & 1) == 0)
            return (arr[(size >> 1) - 1] + arr[size >> 1]) / 2.0;// 偶
        else
            return arr[size >> 1]; // 奇
    }
}