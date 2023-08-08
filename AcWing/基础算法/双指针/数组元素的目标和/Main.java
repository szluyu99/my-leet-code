import java.util.*;

class Main {
    public static void main(String[] args) {
        // hash(); // 哈希
        // binarySearch(); // 二分
        doublePoint(); // 双指针
    }

    // 哈希
    public static void hash() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        int[] B = new int[m];
        
        for (int i = 0; i < n; i++) map.put(sc.nextInt(), i);
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();
         
        for (int i = 0; i < m; i++) {
            if (map.containsKey(x - B[i])) {
                System.out.println(map.get(x - B[i]) + " " + i);
                return;
            }
        }

    }

    // 二分
    public static void binarySearch() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();
         
        for (int i = 0; i < n; i++) {
            int target = x - A[i];
            int l = 0, r = m - 1;
			// 二分
            while (l < r) {
                int mid = (l + r) >> 1;
                if (B[mid] >= target) r = mid;
                else l = mid + 1;
            }
            if (B[l] == target) {
                System.out.println(i + " " + l);
                return;
            }
        }
    }

    // 双指针
    public static void doublePoint() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();

        for (int i = 0, j = m - 1; i < j; ) {
            if (A[i] + B[j] == x) {
                System.out.println(i + " " + j);
                return;
            }
            if (A[i] + B[j] < x) i++;
            else j--;
        } 
    }
}