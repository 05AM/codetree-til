import java.util.Scanner;
public class Main {

    private static int[] dr = { -1, 0, 0, 1 };
    private static int[] dc = { 0, 1, -1, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int result = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int cnt = 0;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }

                    if (arr[nr][nc] == 1) {
                        cnt++;
                    }
                }

                if (cnt >= 3) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}