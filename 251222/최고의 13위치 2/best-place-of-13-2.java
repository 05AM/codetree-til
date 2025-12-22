import java.util.Scanner;
public class Main {

    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        // 겹치면?
        int max = 0;
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < n - 2; c1++) {
                for (int r2 = 0; r2 < n; r2++) {
                    for (int c2 = 0; c2 < n - 2; c2++) {
                        if (isOverlapped(r1, c1, r2, c2)) {
                            continue;
                        }

                        int gridSum1 = 0;
                        int gridSum2 = 0;

                        for (int i = 0; i < 3; i++) {
                            gridSum1 += arr[r1][c1 + i];
                            gridSum2 += arr[r2][c2 + i];
                        }

                        max = Math.max(max, gridSum1 + gridSum2);
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static boolean isOverlapped(int r1, int c1, int r2, int c2) {
        return r1 == r2 && c1 - c2 < 3;
    }
}