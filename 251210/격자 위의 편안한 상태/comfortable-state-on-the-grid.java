import java.util.Scanner;
public class Main {

    public static final int[] dr = new int[] { -1, 0, 1, 0 };
    public static final int[] dc = new int[] { 0, 1, 0, -1 };

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] isColored = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            isColored[r][c] = true;

            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int nr = r + dr[j];
                int nc = c + dc[j];

                if (isInRange(nr, nc) && isColored[nr][nc]) {
                    cnt++;
                }
            }

            System.out.println(cnt == 3 ? 1 : 0);
        }
    }

    public static boolean isInRange(int r, int c) {
        return r >= 1 && r <= n && c >= 1 && c <= n;
    }
}