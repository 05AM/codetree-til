import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        int totalTime = 0;

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();

            totalTime += a[i][1];
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }

        // Please write your code here.
        int[] LocByTimeA = new int[totalTime + 1];
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int v = a[i][0];
            int t = a[i][1];

            while(t-- > 0) {
                LocByTimeA[timeA] += LocByTimeA[timeA - 1] + v;
                timeA++;
            }
        }

        int[] LocByTimeB = new int[totalTime + 1];
        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int v = b[i][0];
            int t = b[i][1];

            while(t-- > 0) {
                LocByTimeB[timeB] += LocByTimeB[timeB - 1] + v;
                timeB++;
            }
        }

        int result = 0;
        for (int i = 1; i <= totalTime; i++) {
            // 내가 찾아야되는 상태
            // 1. a, b의 순서가 역전
            // 2. a, b가 같아짐

            // System.out.println("i: " + i + " - a: " + LocByTimeA[i] + ", b: " + LocByTimeB[i]);

            if (LocByTimeA[i - 1] < LocByTimeB[i - 1] && LocByTimeA[i] >= LocByTimeB[i]) {
                result++;
            } else if (LocByTimeB[i - 1] < LocByTimeA[i -1] && LocByTimeB[i] >= LocByTimeA[i]) {
                result++;
            } else if (LocByTimeA[i - 1] != LocByTimeB[i - 1] && LocByTimeA[i] == LocByTimeB[i]) {
                result++;
            } else if (LocByTimeA[i - 1] == LocByTimeB[i - 1] && LocByTimeA[i] != LocByTimeB[i]) {
                result++;
            }
        }

        System.out.println(result);
    }
}