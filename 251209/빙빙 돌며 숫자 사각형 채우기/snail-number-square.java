import java.util.Scanner;
public class Main {

    private static final int[] dr = new int[] {0, 1, 0, -1};
    private static final int[] dc = new int[] {1, 0, -1, 0};
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] result = new int[n][m];
        int r = 0;
        int c = 0;
        int dirNum = 0;
        int value = 1;

        for (int i = 0; i < n * m; i++) {
            result[r][c] = value++;

            int nr = r + dr[dirNum];
            int nc = c + dc[dirNum];

            if (inRange(nr, nc) && result[nr][nc] == 0) {
                r = nr;
                c = nc;
            } else {
                dirNum = (dirNum + 1) % 4;
                r += dr[dirNum];
                c += dc[dirNum];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}